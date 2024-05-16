package com.cocktail.cocktail.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "cocktails")
@Data
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cocktail_id")
    private int cocktail_id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_s")
    private Double price_s;

    @Column(name = "price_m")
    private Double price_m;

    @Column(name = "price_l")
    private Double price_l;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(name = "cocktail_category",
            joinColumns = @JoinColumn(name = "cocktail_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(name = "cocktails_ingredients",
            joinColumns = @JoinColumn(name = "cocktail_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<Ingredient> ingredients;
}
