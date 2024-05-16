package com.cocktail.cocktail.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ordersCocktailsDetail")
@Data
public class Order_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail;
}
