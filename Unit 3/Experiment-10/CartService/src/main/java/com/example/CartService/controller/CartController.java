package com.example.CartService.controller;

import com.example.CartService.model.CartItem;
import com.example.CartService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    @PostMapping
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cartRepository.save(cartItem);
    }
}
