package E_Commerce.controller;

import E_Commerce.dto.AddToCartRequest;
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
    public Cart getCart(
            Authentication authentication) {

        return cartService.getCart(
                authentication.getName()
        );
    }

}
