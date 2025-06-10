package com.example.demo.Controller;
import com.example.demo.ServiceApplicatif.DemandeLivraisonServiceApp;

import jakarta.validation.Valid;

import java.io.FileNotFoundException;
import java.net.http.HttpRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ModelDTO.DemandeLivraisonDTO;
import com.example.demo.ModelDTO.LivraisonDTO;
import com.example.demo.ModelDomain.DemandeLivraison;

@Validated
@RestController
@RequestMapping("/demandes")
public class DemandeLivraisonController {

    private final DemandeLivraisonServiceApp demandeLivraisonServiceApp;

    public DemandeLivraisonController(DemandeLivraisonServiceApp demandeLivraisonServiceApp){
        this.demandeLivraisonServiceApp = demandeLivraisonServiceApp;
    }

    @PostMapping("/savedemande")
    public ResponseEntity<DemandeLivraisonDTO> saveDemandeLivraison(@RequestBody @Valid DemandeLivraisonDTO demandeLivraisonDTO){
          
         DemandeLivraisonDTO savedDemande = demandeLivraisonServiceApp.saveDemandeLivraison(demandeLivraisonDTO);
         return ResponseEntity.status(HttpStatus.CREATED).body(savedDemande);
      
        }


    
    @PutMapping("/{id}")
    //pathvariable: recupere un variable dynamique depuia l url 
    public ResponseEntity<DemandeLivraisonDTO> updatedDemande(
        
          @PathVariable Long demandeId,
          @RequestBody  @Valid DemandeLivraisonDTO updatedDemande)
        {

        DemandeLivraisonDTO demande= demandeLivraisonServiceApp.updateDemande(demandeId, updatedDemande);
        return ResponseEntity.ok(demande);
        }

  
    @PutMapping("/{demandeId}/annuler")
    public ResponseEntity<Void> annulerDemandeParClient(
       
       @PathVariable Long demandeId, 
       @RequestParam Long userId) 
    {  
        
    demandeLivraisonServiceApp.annulerDemandeParClient(demandeId, userId);
    return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{demandeId}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long demandeId)
    {
        try{
            demandeLivraisonServiceApp.deleteDemande(demandeId);
            return ResponseEntity.ok("demande supprime avec succes");

        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    


      


}
