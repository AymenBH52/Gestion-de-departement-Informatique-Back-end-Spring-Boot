package com.projet_soa.gestion_departement_info.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_soa.gestion_departement_info.dao.EtudiantRepository;
import com.projet_soa.gestion_departement_info.entities.Etudiant;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(Long id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return etudiant.isPresent() ? etudiant.get() : null;
    }

    @Override
    public Etudiant update(Long id, Etudiant etudiant) {

        Optional<Etudiant> existingEtudiant = etudiantRepository.findById(id);
        if (existingEtudiant.isPresent()) {
            Etudiant updatedEtudiant = existingEtudiant.get();
            updatedEtudiant.setCin(etudiant.getCin());
            updatedEtudiant.setNom(etudiant.getNom());
            updatedEtudiant.setPrenom(etudiant.getPrenom());
            updatedEtudiant.setDateNaissance(etudiant.getDateNaissance());
            return etudiantRepository.save(updatedEtudiant);
        } else {
            return null;
        }
    }

    @Override
    public Etudiant add(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void delete(Long id) {

    }

    public void addAbsence(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.getById(etudiantId);
        etudiant.setNumberOfAbsences(etudiant.getNumberOfAbsences() + 1);
        etudiantRepository.save(etudiant);
    }

    public void removeAbsence(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.getById(etudiantId);
        etudiant.setNumberOfAbsences(etudiant.getNumberOfAbsences() - 1);
        etudiantRepository.save(etudiant);
    }

    @Override
    public Integer getNumberOfAbsencesByEtudiantId(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.getById(etudiantId);
        return etudiant.getNumberOfAbsences();
    }

    public Double getTauxAbsenteisme() {
        // Récupère le nombre total d'étudiants
        Long nombreTotalEtudiants = etudiantRepository.count();
        // Calcule le taux d'absentisme
        double tauxAbsentisme = 0;
        if (nombreTotalEtudiants > 0) {
            tauxAbsentisme = (double) etudiantRepository.findAll().stream().map(Etudiant::getNumberOfAbsences).reduce(0,
                    Integer::sum) / nombreTotalEtudiants;
        }

        return tauxAbsentisme;
    }

    public Double getTauxReussite() {
        Long nombreTotalEtudiants = etudiantRepository.count();
        Long nombreTotalReussites = etudiantRepository.findAll().stream().filter(etudiant -> etudiant.getNote() >= 10)
                .count();
        double tauxReussite = (double) nombreTotalReussites / nombreTotalEtudiants;
        return tauxReussite;
    }

    public Boolean Reussi(Etudiant etudiant) {
        return etudiant.getNote() >= 10;
    }

}
