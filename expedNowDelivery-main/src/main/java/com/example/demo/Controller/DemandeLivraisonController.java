package com.example.demo.Controller;
import com.example.demo.ServiceApplicatif.DemandeLivraisonServiceApp;

import jakarta.validation.Valid;

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
        
          @PathVariable Long id,
          @RequestBody  @Valid DemandeLivraisonDTO updatedDemande)
        {

        DemandeLivraisonDTO demande= demandeLivraisonServiceApp.update(id, updatedDemande);
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




     @PutMapping("/{id}/accepter")
    public ResponseEntity<Void> acceptationParLivreur(
        @PathVariable Long id,
        @RequestParam Long livreurId) {
    
    demandeLivraisonServiceApp.acceptationParLivreur(livreurId, id);
    return ResponseEntity.ok().build();
    }


    @PutMapping("/{livraisonId}/annulerL")
    public ResponseEntity<Void> annulerLivraisonParClient(
        @PathVariable Long livraisonId,
        @RequestParam Long demandeId,
        @RequestParam Long userId) {
            
    demandeLivraisonServiceApp.annulerLivraisonParClient(livraisonId, userId,demandeId );
    return ResponseEntity.ok().build();
        }

    @PostMapping("/{livraisonId}/commencerL")
    public ResponseEntity<Void> commencerLivraison(
         @PathVariable Long livraisonId,
         @RequestParam Long livreurId) {

    demandeLivraisonServiceApp.commencerLivraison(livraisonId, livreurId);
    return ResponseEntity.ok().build();
}

  @PutMapping("/{livraisonId}/acheverL")
  public ResponseEntity<Void> livraisonAchever(
       @PathVariable Long livraisonId,
       @RequestParam Long livreurId ) {

    demandeLivraisonServiceApp.livraisonAchever(livraisonId, livreurId);
    return ResponseEntity.ok().build();
     
}

}
