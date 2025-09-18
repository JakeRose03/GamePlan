package com.GamePlan.GamePlan.dto.requests;

import com.GamePlan.GamePlan.model.Role;

import lombok.Data;

@Data
public class RegistrationRequest {
   private String userName;
   private String email;
   private String passWord;
   private Role role; 
}
