package com.cocktail.cocktail.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cocktails_ingredients")
@Data
public class CocktailIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*@ManyToOne
    @MapsId("cocktail_id")*/
    private int cocktail_id;

    /*@ManyToOne
    @MapsId("ingredient_id")*/
    private int ingredient_id;
}