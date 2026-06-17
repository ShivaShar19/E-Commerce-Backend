package E_Commerce.service.impl;

import E_Commerce.dto.AddToCartRequest;
import E_Commerce.dto.CartItemResponse;
import E_Commerce.dto.CartResponse;
import E_Commerce.dto.UpdateCartRequest;
import E_Commerce.entity.Cart;
import E_Commerce.entity.CartItem;
import E_Commerce.entity.Product;
import E_Commerce.entity.User;
import E_Commerce.exception.ResourceNotFoundException;
import E_Commerce.repository.CartItemRepository;
import E_Commerce.repository.CartRepository;
import E_Commerce.repository.ProductRepository;
import E_Commerce.repository.UserRepository;
import E_Commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public Cart addToCart(String email,
                          AddToCartRequest request) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with email: "+ email));

        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = Cart.builder()
                            .user(user)
                            .build();

                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(
                        request.getProductId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found with id: " + request.getProductId()));

        CartItem item = CartItem.builder()
                .cart(cart)
                .product(product)
                .quantity(request.getQuantity())
                .subtotal(
                        product.getPrice().multiply(
                                BigDecimal.valueOf(
                                        request.getQuantity()
                                )
                        )
                )
                .build();

        cartItemRepository.save(item);

        return cartRepository.findById(cart.getId()).get();
    }

    @Override
    public CartResponse getCart(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with email: "+ email));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found for user: " + email));

        BigDecimal total = cart.getItems()
                .stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<CartItemResponse> items = cart.getItems()
                .stream()
                .map(item -> CartItemResponse.builder()
                        .cartItemId(item.getId())
                        .productName(item.getProduct().getName())
                        .quantity(item.getQuantity())
                        .price(item.getProduct().getPrice())
                        .subtotal(item.getSubtotal())
                        .build())
                .toList();

        return CartResponse.builder()
                .items(items)
                .totalAmount(total)
                .build();
    }

    @Override
    public Cart updateCartItem(
            String email,
            UpdateCartRequest request) {

        System.out.println("REQUEST = " + request);
        System.out.println("CartItemId = " + request.getCartItemId());
        System.out.println("Quantity = " + request.getQuantity());

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with email: "+ email));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found for user: " + email));

        CartItem cartItem =
                cartItemRepository.findById(
                                request.getCartItemId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart Item not found"));

        if (!cartItem.getCart().getId()
                .equals(cart.getId())) {

            throw new RuntimeException(
                    "Unauthorized cart item");
        }

        cartItem.setQuantity(
                request.getQuantity());

        cartItem.setSubtotal(
                cartItem.getProduct()
                        .getPrice()
                        .multiply(
                                BigDecimal.valueOf(
                                        request.getQuantity()
                                )
                        )
        );

        cartItemRepository.save(cartItem);

        return cart;
    }

    @Override
    public void removeCartItem(
            String email,
            Long cartItemId) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with email: "+ email));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found for user: " + email));

        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart item not found"));


        if (!cartItem.getCart().getId()
                .equals(cart.getId())) {

            throw new RuntimeException(
                    "Unauthorized cart item");
        }

        cartItemRepository.delete(cartItem);
    }


}
