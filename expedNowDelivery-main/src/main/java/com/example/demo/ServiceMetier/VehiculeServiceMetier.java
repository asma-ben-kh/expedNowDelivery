package com.example.demo.ServiceMetier;
import com.example.demo.ModelDomain.Vehicule;

public interface VehiculeServiceMetier {

    public Vehicule saveVoiture(Vehicule vehicule);
    public Void deleteVehicule(Long id);
    public Vehicule updateVehicule(Vehicule vehicule);
    public void assignerVehicule(Long id, long livreurId);

}
