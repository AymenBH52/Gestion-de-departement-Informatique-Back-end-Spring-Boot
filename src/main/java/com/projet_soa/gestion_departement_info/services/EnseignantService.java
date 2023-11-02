package com.projet_soa.gestion_departement_info.services;

import java.util.List;

import com.projet_soa.gestion_departement_info.entities.Enseignant;

public interface EnseignantService {

    List<Enseignant> getAllEnseignants();
    Enseignant getEnseignantById(Long id);
    Enseignant saveEnseignant(Enseignant enseignant);
    Enseignant updateEnseignant(Long id, Enseignant enseignant);
    void deleteEnseignantById(Long id);
    
}
