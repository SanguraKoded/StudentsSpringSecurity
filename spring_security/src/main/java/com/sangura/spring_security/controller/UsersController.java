package com.sangura.spring_security.controller;

import com.sangura.spring_security.model.Users;
import com.sangura.spring_security.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService service;


    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.registerUsers(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {

        return service.verify(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable int id){
        return ResponseEntity.ok(service.getUserById(id));
    }

}
