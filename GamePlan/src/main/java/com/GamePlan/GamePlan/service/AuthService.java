package com.GamePlan.GamePlan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.GamePlan.GamePlan.dto.requests.RegistrationRequest;
import com.GamePlan.GamePlan.dto.response.UserResponse;
import com.GamePlan.GamePlan.model.User;
import com.GamePlan.GamePlan.repo.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    public UserResponse register(RegistrationRequest req){
           // basic checks (adjust to your needs)
        if (userRepo.existsByUserName(req.getUserName())) throw new IllegalArgumentException("Username taken");
        if (userRepo.existsByEmail(req.getEmail())) throw new IllegalArgumentException("Account already registered");

        User u = new User();
        u.setUserName(req.getUserName().trim());
        u.setEmail(req.getEmail().trim());
        u.setRole(req.getRole());
        // IMPORTANT: encode once; never double-encode
        String hashed = encoder.encode(req.getPassWord());   // BCrypt -> 60-char hash
        u.setPassword(hashed);

        User saved = userRepo.save(u);
        return new UserResponse(saved.getUserName(), saved.getEmail(), saved.getId());

        
    }


}
