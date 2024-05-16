package com.cocktail.cocktail.repository;

import com.cocktail.cocktail.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
