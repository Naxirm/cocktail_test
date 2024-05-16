package com.cocktail.cocktail.controller;

import com.cocktail.cocktail.model.User;
import com.cocktail.cocktail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/users")
    public List<User> GetUser() {
        return userRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/user")
    public User GetUserById(@RequestParam int id) {
        return userRepository.findById(id).orElse(null);
    }
}
