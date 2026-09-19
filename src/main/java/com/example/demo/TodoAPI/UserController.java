package com.example.demo.TodoAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
       List<User> users= userRepository.findAll();

       return ResponseEntity.ok(users);
    }
}
