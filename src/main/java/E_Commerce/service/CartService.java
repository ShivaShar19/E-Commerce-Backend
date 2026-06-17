package E_Commerce.service;

import E_Commerce.dto.AddToCartRequest;
import E_Commerce.entity.Cart;

public interface CartService {

    Cart addToCart(String email, AddToCartRequest request);

    Cart getCart(String email);

}
