package com.cocktail.cocktail.repository;

import com.cocktail.cocktail.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {
}
