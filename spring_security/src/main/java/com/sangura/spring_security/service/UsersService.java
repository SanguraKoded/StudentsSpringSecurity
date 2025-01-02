package com.sangura.spring_security.service;

import com.sangura.spring_security.model.Users;
import com.sangura.spring_security.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;


    @Autowired
    AuthenticationManager authManager;


    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users registerUsers(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }

    public List<Users> getAllUsers(){
        return usersRepo.findAll();
    }

    public Users getUserById(int id){
        return usersRepo.findById(id).orElseThrow(() -> new RuntimeException("Given User Id is incorrect."));
    }

}
