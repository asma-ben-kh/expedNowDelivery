package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ModelDTO.VehiculeDTO;
import com.example.demo.ServiceApplicatif.VehiculeServiceApp;

@RestController
@RequestMapping("/")
public class VehiculeController {

    private final VehiculeServiceApp vehiculeServiceApp;

    public VehiculeController(VehiculeServiceApp vehiculeServiceApp){
        this.vehiculeServiceApp = vehiculeServiceApp;
    }

   @PostMapping("/saveVehicule")
   public ResponseEntity<VehiculeDTO> saveVehicule(@RequestBody VehiculeDTO vehiculeDTO){

        VehiculeDTO saved = vehiculeServiceApp.saveVoiture(vehiculeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteVehicule(@PathVariable Long id){

      vehiculeServiceApp.deleteVehicule(id);
      return ResponseEntity.noContent().build();
   }

   @PutMapping("/{id}")
   public ResponseEntity<VehiculeDTO> updateVehicule(
    @PathVariable Long id,
    @RequestParam  VehiculeDTO vehiculeDTO)
  
    {
      VehiculeDTO updatedvehicule  = vehiculeServiceApp.updateVehicule(id, vehiculeDTO);
       return ResponseEntity.status(HttpStatus.OK).body(updatedvehicule);
   }


   @GetMapping("/{id}")
   public ResponseEntity<VehiculeDTO> getById(@PathVariable Long id)
   {

    VehiculeDTO vehicule = vehiculeServiceApp.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(vehicule);
   }


   @GetMapping("/getAll")
   public ResponseEntity<List<VehiculeDTO>> getAll(){

    List<VehiculeDTO> vehicule = vehiculeServiceApp.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(vehicule);
    
   }
}
