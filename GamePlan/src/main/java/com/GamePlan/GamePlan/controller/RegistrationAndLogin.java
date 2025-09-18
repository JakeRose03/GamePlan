package com.GamePlan.GamePlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GamePlan.GamePlan.dto.requests.RegistrationRequest;
import com.GamePlan.GamePlan.dto.response.UserResponse;
import com.GamePlan.GamePlan.service.AuthService;

@RestController
public class RegistrationAndLogin {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegistrationRequest req){
        UserResponse userResponse = authService.register(req);
        return ResponseEntity.status(201).body(userResponse);

    }

    @GetMapping("/login")
    public String login(){
       return " logged in" ;
    }
}
