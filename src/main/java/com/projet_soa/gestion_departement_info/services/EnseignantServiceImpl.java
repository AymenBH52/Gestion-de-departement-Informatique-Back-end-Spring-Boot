package com.projet_soa.gestion_departement_info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_soa.gestion_departement_info.dao.EnseignantRepository;
import com.projet_soa.gestion_departement_info.entities.Enseignant;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    @Autowired
    EnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id).get();
    }

    public Enseignant updateEnseignant(Long id,  Enseignant enseignant) {
        enseignant.setId(id);
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public void deleteEnseignantById(Long id) {
        enseignantRepository.deleteById(id);

    }
}