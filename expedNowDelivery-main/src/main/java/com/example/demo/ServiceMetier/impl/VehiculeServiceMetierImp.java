package com.example.demo.ServiceMetier.impl;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.ServiceMetier.*;

import com.example.demo.ModelDomain.Vehicule;
import com.example.demo.ServiceMetier.VehiculeServiceMetier;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.VehiculeAlreadyExistException;
import com.example.demo.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Service
public class VehiculeServiceMetierImp  implements VehiculeServiceMetier{

    private final VehiculeRepository vehiculeRepository;


    public VehiculeServiceMetierImp(VehiculeRepository vehiculeRepository ){
        this.vehiculeRepository = vehiculeRepository;
    }


    @Override
    public void assignerVehicule(Long VehiculeId, long livreurId) {
        List<Vehicule> = vehiculeRepository.findAllByDisponibleTrue();
        
    }

    @Override
    public void deleteVehicule(Long id) {

      Optional<Vehicule> optionalVehicule = vehiculeRepository.findById(id);
      //le orelsethrow retoune l objet ou declanche une exception

       Vehicule vehicule = optionalVehicule.orElseThrow(() -> new NotFoundException("Véhicule avec id " + id + " introuvable"));
       

            vehiculeRepository.delete(vehicule);
        }
    

    @Override
    public Vehicule saveVoiture(Vehicule vehicule) {

        List<String> conflits = new ArrayList<>();

        if(vehiculeRepository.existsByMatricule(vehicule.getMatricule())){

            conflits.add("matricule");
        }

      if(vehiculeRepository.existsByNumSerie(vehicule.getNumSerie())){

           conflits.add("NumSerie");
        }

        if(!conflits.isEmpty()){

            throw new VehiculeAlreadyExistException(conflits);
        }

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule updateVehicule(Long vehiculeId, Vehicule vehiculeUpdated) {
        Vehicule vehiculeExisting = vehiculeRepository.findById(vehiculeId).orElseThrow(() -> new NotFoundException("vehicule " + vehiculeId + "introuvable"));

        vehiculeExisting.setMatricule(vehiculeUpdated.getMatricule());
        vehiculeExisting.setNumSerie(vehiculeUpdated.getNumSerie());
        vehiculeExisting.setLivreur(vehiculeUpdated.getLivreur());


        return vehiculeRepository.save(vehiculeExisting);
         
    }


    @Override
    public List<Vehicule> getAll() {
      
        List<Vehicule> ListVec = vehiculeRepository.findAll();
        return (ListVec);
        
    }


    @Override
    public Vehicule getById(Long id) {
        return  vehiculeRepository.findById(id).orElseThrow(() -> new NotFoundException("Véhicule avec l'id " + id + " introuvable"));
    }


    

}
