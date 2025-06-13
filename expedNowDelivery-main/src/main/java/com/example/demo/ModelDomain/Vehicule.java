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
import lombok.Setter;
import jakarta.persistence.CascadeType;
import com.example.demo.ModelDomain.User;

@Entity
@Getter
@Setter
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private Long id;
     private String matricule;
     private Long numSerie;

     @OneToOne
     @JoinColumn(name = "livreur")
     private User livreur;

     public Vehicule(Long id, String matricule, Long numSerie, User livreur) {
    this.id = id;
    this.matricule = matricule;
    this.numSerie = numSerie;
    this.livreur = livreur;
}

}
