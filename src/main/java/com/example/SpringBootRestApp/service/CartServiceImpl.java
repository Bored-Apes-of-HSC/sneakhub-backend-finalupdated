package com.example.SpringBootRestApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootRestApp.model.Cart;
import com.example.SpringBootRestApp.model.Product;
import com.example.SpringBootRestApp.repository.CartRepo;
import com.example.SpringBootRestApp.repository.ProductRepo;

import jakarta.transaction.Transactional;

@Service
public class CartServiceImpl implements CartService {
	
	  @Autowired
	    private CartRepo cartRepository;

	    @Autowired
	    private ProductRepo productRepository;

	    @Transactional
	    public void addToCart(int productId, int quantity) {
	        Cart existingCartItem = cartRepository.findByPid(productId);
	        if (existingCartItem != null) {
	            // If the product already exists in the cart, update its quantity
	            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
	            cartRepository.save(existingCartItem);
	        } else {
	            // If the product doesn't exist in the cart, add it as a new entry
	            Product product = productRepository.findById(productId).orElse(null);
	            if (product != null) {
	                Cart newCartItem = new Cart();
	                newCartItem.setPid(productId);
	                newCartItem.setQuantity(quantity);
	                newCartItem.setPrice(product.getPrice() * quantity);
	                newCartItem.setImageURL(product.getImageURL());
		            newCartItem.setName(product.getName());
		            newCartItem.setBrand(product.getBrand());
	                cartRepository.save(newCartItem);
	            }
	        }
	    }

	    @Transactional
	    public void removeFromCart(int productId) {
	        cartRepository.deleteByPid(productId);
	    }
	    
	    public List<Cart> getCartProducts(){
	    	return cartRepository.findAll();
	    }
	    
	    @Transactional
	    public void updateQuantity(int productId, int quantity) {
	        Cart cartItem = cartRepository.findByPid(productId);
	        if (cartItem != null) {
	            cartItem.setQuantity(quantity);
	            cartRepository.save(cartItem);
	        }
	    } 

}
