package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
   public ResponseEntity<VehiculeDTO> saveVehicule()


}
