package com.projet_soa.gestion_departement_info.services;

import java.util.List;

import com.projet_soa.gestion_departement_info.entities.Etudiant;

public interface EtudiantService {
    public List<Etudiant> getAllEtudiants();

    public Etudiant findById(Long id);

    public Etudiant update(Long id, Etudiant etudiant);

    public Etudiant add(Etudiant etudiant);

    public void delete(Long id);

    public Integer getNumberOfAbsencesByEtudiantId(Long etudiantId);

    public void addAbsence(Long etudiantId);

    public void removeAbsence(Long etudiantId);

    public Double getTauxAbsenteisme();

    public Double getTauxReussite();

    public Boolean Reussi(Etudiant etudiant);
}
