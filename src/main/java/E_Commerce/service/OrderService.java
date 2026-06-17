package E_Commerce.service;

import E_Commerce.entity.Order;

public interface OrderService {

    Order placeOrder(String email);
}
