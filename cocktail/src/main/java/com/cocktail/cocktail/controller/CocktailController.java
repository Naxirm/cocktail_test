package com.cocktail.cocktail.controller;

import com.cocktail.cocktail.model.Cocktail;
import com.cocktail.cocktail.repository.CocktailRepository;
import com.cocktail.cocktail.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CocktailController {

    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private CocktailService cocktailService;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/cocktails")
    public List<Cocktail> GetCocktail() {
        return cocktailRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/cocktail")
    public ResponseEntity<Cocktail> createCocktail(@RequestBody Cocktail cocktail) {
        Cocktail createdCocktail = cocktailService.createCocktail(cocktail);
        return new ResponseEntity<>(createdCocktail, HttpStatus.CREATED);
    }
}