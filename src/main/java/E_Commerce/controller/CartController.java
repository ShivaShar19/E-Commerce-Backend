package E_Commerce.controller;

import E_Commerce.dto.AddToCartRequest;
import E_Commerce.dto.CartResponse;
import E_Commerce.dto.UpdateCartRequest;
import E_Commerce.entity.Cart;
import E_Commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(
            Authentication authentication,
            @RequestBody AddToCartRequest request) {

        return cartService.addToCart(
                authentication.getName(),
                request
        );
    }

    @GetMapping
    public CartResponse getCart(
            Authentication authentication) {

        return cartService.getCart(
                authentication.getName()
        );
    }

    @PutMapping("/update")
    public Cart updateCartItem(
            Authentication authentication,
            @RequestBody UpdateCartRequest request) {

        return cartService.updateCartItem(
                authentication.getName(),
                request
        );
    }

    @DeleteMapping("/remove/{cartItemId}")
    public String removeCartItem(
            Authentication authentication,
            @PathVariable Long cartItemId) {

        cartService.removeCartItem(
                authentication.getName(),
                cartItemId
        );

        return "Item removed successfully";
    }

}
