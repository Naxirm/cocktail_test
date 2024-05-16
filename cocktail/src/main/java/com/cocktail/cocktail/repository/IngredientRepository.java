package com.cocktail.cocktail.repository;

import com.cocktail.cocktail.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
