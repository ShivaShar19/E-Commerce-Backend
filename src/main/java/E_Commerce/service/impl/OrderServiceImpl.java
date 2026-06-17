package E_Commerce.service.impl;

import E_Commerce.entity.*;
import E_Commerce.repository.*;
import E_Commerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public Order placeOrder(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        BigDecimal total = cart.getItems()
                .stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = Order.builder()
                .user(user)
                .totalAmount(total)
                .status(OrderStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        order = orderRepository.save(order);

        for (CartItem cartItem : cart.getItems()) {

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(cartItem.getProduct())
                    .quantity(cartItem.getQuantity())
                    .price(cartItem.getProduct().getPrice())
                    .subtotal(cartItem.getSubtotal())
                    .build();

            orderItemRepository.save(orderItem);
        }

        cartItemRepository.deleteAll(cart.getItems());

        cart.getItems().clear();
        cartRepository.save(cart);

        return orderRepository.findById(order.getId())
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getMyOrders(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return orderRepository.findByUser(user);
    }

    private boolean isValidTransition(OrderStatus current, OrderStatus next) {

        switch (current) {

            case PENDING:
                return next == OrderStatus.CONFIRMED;

            case CONFIRMED:
                return next == OrderStatus.SHIPPED;

            case SHIPPED:
                return next == OrderStatus.DELIVERED;

            case DELIVERED:
                return false;

            default:
                return false;
        }
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!isValidTransition(order.getStatus(), status)) {
            throw new RuntimeException(
                    "Invalid status transition: "
                            + order.getStatus() + " → " + status
            );
        }

        order.setStatus(status);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }


}
