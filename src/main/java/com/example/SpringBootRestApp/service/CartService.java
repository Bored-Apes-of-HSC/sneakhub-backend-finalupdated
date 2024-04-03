package com.example.SpringBootRestApp.service;

import java.util.List;

import com.example.SpringBootRestApp.model.Cart;

public interface CartService {

	
	 public void addToCart(int productId, int quantity);
	 public void removeFromCart(int productId);
	 public List<Cart> getCartProducts();
	 public void updateQuantity(int productId, int quantity) ;
}
