package com.cocktail.cocktail.repository;

import com.cocktail.cocktail.model.Order_detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<Order_detail, Integer> {
}
