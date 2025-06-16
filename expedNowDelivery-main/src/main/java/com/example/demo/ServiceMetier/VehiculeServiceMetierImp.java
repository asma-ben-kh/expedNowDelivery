package com.example.demo.ServiceMetier;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.ModelDomain.Vehicule;
import com.example.demo.ServiceMetier.VehiculeServiceMetier;
import com.example.demo.exception.NotDeleted;
import com.example.demo.exception.NotSaved;
import com.example.demo.exception.NotFound;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.VehiculeRepository;
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

        Vehicule vehiculesaved = vehiculeRepository.save(vehicule);
        if(vehiculesaved == null || vehiculesaved.getId() == null){
            throw new NotSaved("Le véhicule n'a pas pu être enregistré.");
        }
         return vehiculesaved;

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
    public Vehicule getAll() {
        return vehiculeRepository.findAll();
        
    }


    @Override
    public Vehicule getById(Long id) {
        return  vehiculeRepository.findById(id).orElseThrow(() -> new NotFoundException("Véhicule avec l'id " + id + " introuvable"));
    }


    

}
