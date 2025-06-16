package com.example.demo.ServiceApplicatif;
import org.mapstruct.MappingTarget;

import com.example.demo.Mapper.VehiculeMapper;
import com.example.demo.ModelDTO.VehiculeDTO;
import com.example.demo.ModelDomain.Vehicule;
import com.example.demo.ServiceMetier.VehiculeServiceMetier;

public class VehiculeServiceApp {

    private final VehiculeMapper vehiculeMapper;
    private final VehiculeServiceMetier vehiculeServiceMetier;


    public VehiculeServiceApp(VehiculeMapper vehiculeMapper, VehiculeServiceMetier vehiculeServiceMetier){

        this.vehiculeMapper = vehiculeMapper;
        this.vehiculeServiceMetier = vehiculeServiceMetier;
    }


    public  VehiculeDTO saveVoiture(VehiculeDTO vehiculeDTO){

        Vehicule vehicule = vehiculeMapper.toEntity(vehiculeDTO);
        Vehicule vehiculeSaved = vehiculeServiceMetier.saveVoiture(vehicule);
        return vehiculeMapper.toDto(vehiculeSaved);

    }

    public void deleteVehicule(Long id){

         vehiculeServiceMetier.deleteVehicule(id);
    }


    public VehiculeDTO updateVehicule(Long vehiculeId,  VehiculeDTO vehiculeUpdatedDTO){

        //recupere l entite existante 
        Vehicule existing =
        Vehicule vehicule = vehiculeMapper.toEntity(vehiculeUpdatedDTO);
        Vehicule vehiculeUpdated = vehiculeServiceMetier.updateVehicule(vehiculeId, vehicule);
        return vehiculeMapper.toDto(vehiculeUpdated);
    }
}
