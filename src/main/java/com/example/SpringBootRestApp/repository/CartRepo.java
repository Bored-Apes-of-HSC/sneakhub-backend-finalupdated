package com.example.SpringBootRestApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootRestApp.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{

	void deleteByPid(int productId);
	Cart findByPid(int productId);
}
