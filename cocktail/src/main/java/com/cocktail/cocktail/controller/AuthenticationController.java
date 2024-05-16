package com.cocktail.cocktail.controller;

import com.cocktail.cocktail.dto.LoginDto;
import com.cocktail.cocktail.dto.RegisterDto;
import com.cocktail.cocktail.model.User;
import com.cocktail.cocktail.repository.UserRepository;
import com.cocktail.cocktail.service.AuthenticationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        if(userRepository.existsByEmail(loginDto.getEmail()) &&
                AuthenticationService.checkPassword(loginDto.getPassword(),AuthenticationService.EncodePassword(loginDto.getPassword()))){
            authenticationService.loginUser(loginDto.getEmail(),userRepository.findByEmail(loginDto.getEmail()).get());
            return ResponseEntity.ok(userRepository.findByEmail(loginDto.getEmail()).orElse(null));
        }else{
            return new ResponseEntity<>("Not authorized", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDto registerDto) {
        if(userRepository.existsByEmail(registerDto.getEmail())){
            return new ResponseEntity<>("Email is already used", HttpStatus.BAD_REQUEST);
        }else{
            User user = new User();
            user.setEmail(registerDto.getEmail());
            user.setPassword(AuthenticationService.EncodePassword(registerDto.getPassword()));
            user.setUser_type("Barmaker");
            userRepository.save(user);

            authenticationService.loginUser(user.getEmail(),user);
            return ResponseEntity.ok(user);
        }
    }
}
