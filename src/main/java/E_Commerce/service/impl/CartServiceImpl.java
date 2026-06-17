package E_Commerce.service.impl;

import E_Commerce.dto.AddToCartRequest;
import E_Commerce.entity.Cart;
import E_Commerce.entity.CartItem;
import E_Commerce.entity.Product;
import E_Commerce.entity.User;
import E_Commerce.repository.CartItemRepository;
import E_Commerce.repository.CartRepository;
import E_Commerce.repository.ProductRepository;
import E_Commerce.repository.UserRepository;
import E_Commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
                        new RuntimeException("User not found"));

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
                        new RuntimeException("Product not found"));

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
    public Cart getCart(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return cartRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Cart not found"));
    }


}
