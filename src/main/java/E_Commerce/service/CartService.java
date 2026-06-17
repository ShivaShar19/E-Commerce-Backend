package E_Commerce.service;

import E_Commerce.dto.AddToCartRequest;
import E_Commerce.dto.CartResponse;
import E_Commerce.dto.UpdateCartRequest;
import E_Commerce.entity.Cart;

public interface CartService {

    Cart addToCart(String email, AddToCartRequest request);

    CartResponse getCart(String email);

    Cart updateCartItem(String email, UpdateCartRequest request);

    void removeCartItem(String email, Long cartItemId);

}
