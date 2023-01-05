package com.example.crud.controller;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String getAll(){
        return "";
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        try{
            User data = userRepository
                    .save(new User(
                            user.getName(),
                            user.getEmail(),
                            user.getPassword(),
                            user.getCreated_at()
                    ));
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
