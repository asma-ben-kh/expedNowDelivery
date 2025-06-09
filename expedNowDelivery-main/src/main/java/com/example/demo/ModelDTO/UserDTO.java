package com.example.demo.ModelDTO;

import com.example.demo.ModelDomain.UserRole;

import lombok.Data;

@Data
 public class UserDTO {
    private Long id;  
    private String fullName;
    private String adress;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private boolean disponible;
    private boolean active;
    private double latitude;
    private double longitude;
}



