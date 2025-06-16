package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ModelDomain.Vehicule;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long>{

    List<Vehicule> findAllByDisponibleTrue();
    Optional<Vehicule> findById(Long id);
    List<Vehicule> findAll();

}
