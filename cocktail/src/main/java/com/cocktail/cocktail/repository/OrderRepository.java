package com.cocktail.cocktail.repository;

import com.cocktail.cocktail.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
