package com.projet_soa.gestion_departement_info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet_soa.gestion_departement_info.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    public Etudiant getById(Long etudiantId);
}
