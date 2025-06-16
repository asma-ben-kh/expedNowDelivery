package com.example.demo.ModelDomain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import com.example.demo.ModelDomain.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false, unique = true)
     private String matricule;

     @Column(nullable = false)
     private Long numSerie;
     
     @Column(nullable = false)
     private boolean disponible=true; 

     @OneToOne
     @JoinColumn(name = "livreur_id")
     private User livreur;

     public Vehicule(Long id, String matricule, Long numSerie, User livreur, boolean disponible) {
    this.id = id;
    this.matricule = matricule;
    this.numSerie = numSerie;
    this.livreur = livreur;
    this.disponible = disponible;
}

}
