package com.example.demo.ModelDTO;

import com.example.demo.ModelDomain.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
 public class UserDTO {
    private Long id;

    @NotBlank(message = "Le nom complet est obligatoire.")
    private String fullName;
    
    @NotBlank(message = "L'adresse est obligatoire.")
     private String adress;

    @Email
    private String email;
    
    private String phoneNumber;
    private UserRole role;
    private boolean disponible;
    private boolean active;
    private double latitude;
    private double longitude;
}



