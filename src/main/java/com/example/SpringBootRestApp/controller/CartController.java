package com.example.SpringBootRestApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootRestApp.model.Cart;
import com.example.SpringBootRestApp.service.CartService;

@RestController
@CrossOrigin
public class CartController {

	 @Autowired
	    private CartService cartService;
	 
        //API for adding any product to cart
	    @PostMapping("/cart/add/{pid}/{quantity}")
	    public ResponseEntity<String> addToCart(@PathVariable int pid, @PathVariable int quantity) {
	        cartService.addToCart(pid, quantity);
	        return ResponseEntity.ok("Product added to cart successfully");
	    }

	    //API for deleting items from cart
	    @DeleteMapping("/cart/remove/{productId}")
	    public ResponseEntity<String> removeFromCart(@PathVariable int productId) {
	        cartService.removeFromCart(productId);
	        return ResponseEntity.ok("Product removed from cart successfully");
	    }
	    
	    //API to display all the items in the cart
	    @GetMapping("/cart")
	    public List<Cart> getCartProducts(){
	    	return cartService.getCartProducts();
	    }
	    
	    //API to update quantity of a product in the cart
	    @PutMapping("/cart/update/{productId}/{quantity}")
	    public ResponseEntity<String> updateQuantity(@PathVariable int productId, @PathVariable int quantity) {
	        cartService.updateQuantity(productId, quantity);
	        return ResponseEntity.ok("Quantity updated successfully");
	    }

}
