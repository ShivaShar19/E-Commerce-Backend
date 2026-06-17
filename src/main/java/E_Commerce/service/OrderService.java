package E_Commerce.service;

import E_Commerce.entity.Order;
import E_Commerce.entity.OrderStatus;

import java.util.List;

public interface OrderService {

    Order placeOrder(String email);

    List<Order> getMyOrders(String email);

    Order updateOrderStatus(Long orderId, OrderStatus status);

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

}
