package com.example.demo.ServiceMetier;
import com.example.demo.ModelDomain.Vehicule;

public interface VehiculeServiceMetier {

    public Vehicule saveVoiture(Vehicule vehicule);
    public void deleteVehicule(Long id);
    public Vehicule updateVehicule(Long vehiculeId, Vehicule vehiculeUpdated);
    public void assignerVehicule(Long id, long livreurId);

}
