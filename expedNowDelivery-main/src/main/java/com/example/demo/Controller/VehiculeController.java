package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ModelDTO.VehiculeDTO;
import com.example.demo.ModelDomain.Vehicule;
import com.example.demo.ServiceApplicatif.VehiculeServiceApp;
import com.example.demo.ModelDTO.SaveVehiculeRequestDTO;
import com.example.demo.ModelDTO.UpdatevehiculeRequestDTO;;


@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    private final VehiculeServiceApp vehiculeServiceApp;

    public VehiculeController(VehiculeServiceApp vehiculeServiceApp){
        this.vehiculeServiceApp = vehiculeServiceApp;
    }

   @PostMapping("/")
   public ResponseEntity<VehiculeDTO> saveVehicule(@RequestBody  SaveVehiculeRequestDTO saveVehiculeRequestDTO){

        VehiculeDTO saved = vehiculeServiceApp.saveVoiture(saveVehiculeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

   }

   @PutMapping("/{id}")
   public ResponseEntity<VehiculeDTO> updateVehicule(@PathVariable Long id, @RequestBody UpdatevehiculeRequestDTO updatevehiculeRequestDTO ){
      VehiculeDTO updatedvehicule  = vehiculeServiceApp.updateVehicule(id, updatevehiculeRequestDTO);
       return ResponseEntity.status(HttpStatus.OK).body(updatedvehicule);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteVehicule(@PathVariable Long id){

      vehiculeServiceApp.deleteVehicule(id);
      return ResponseEntity.noContent().build();
   }


   @GetMapping("/{id}")
   public ResponseEntity<VehiculeDTO> getById(@PathVariable Long id)
   {

    VehiculeDTO vehicule = vehiculeServiceApp.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(vehicule);
   }


   @GetMapping("/")
   public ResponseEntity<List<VehiculeDTO>> getAll(){

    List<VehiculeDTO> vehicule = vehiculeServiceApp.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(vehicule);
    
   }

   @GetMapping("/getAllVehiDispo")
   public ResponseEntity<List<VehiculeDTO>> getAllVehiDispo(){

     List<VehiculeDTO> vehiculeDispo = vehiculeServiceApp.getAllVehiculeDispo();
     return ResponseEntity.status(HttpStatus.OK).body(vehiculeDispo);

   }

   @PutMapping("/assignment-auto/{livreurId}")
    public ResponseEntity<?> assignerVehiculeToLivreurAuto(@PathVariable Long livreurId){

     vehiculeServiceApp.assignerVehicule(livreurId);
     return ResponseEntity.ok("Véhicule assigné avec succès");

   }

    @PutMapping("/{id}/assignment/{livreurId}")
    public ResponseEntity<?> assignerVehiculeToLivreur(@PathVariable Long id,@PathVariable Long livreurId){

     vehiculeServiceApp.assignerVehicule(id);
     return ResponseEntity.ok("Véhicule assigné avec succès");

   }



}
