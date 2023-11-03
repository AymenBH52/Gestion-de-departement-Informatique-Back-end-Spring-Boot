package com.projet_soa.gestion_departement_info.services;

import java.util.List;
import java.util.Optional;

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

    public Enseignant updateEnseignant(Long id, Enseignant enseignant) {
        Optional<Enseignant> existingEnseignant = enseignantRepository.findById(id);
        if (existingEnseignant.isPresent()) {
            Enseignant updatedEnseignant = existingEnseignant.get();
            updatedEnseignant.setNom(enseignant.getNom());
            updatedEnseignant.setPrenom(enseignant.getPrenom());
            updatedEnseignant.setEmail(enseignant.getEmail());
            updatedEnseignant.setTelephone(enseignant.getTelephone());
            updatedEnseignant.setAdresse(enseignant.getAdresse());
            updatedEnseignant.setSexe(enseignant.getSexe());
            updatedEnseignant.setGrade(enseignant.getGrade());
            updatedEnseignant.setSpecialite(enseignant.getSpecialite());
            return enseignantRepository.save(updatedEnseignant);
        } else {
            return null;
        }
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