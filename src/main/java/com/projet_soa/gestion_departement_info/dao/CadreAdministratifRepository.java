package com.projet_soa.gestion_departement_info.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_soa.gestion_departement_info.entities.CadreAdministratif;

public interface CadreAdministratifRepository extends JpaRepository<CadreAdministratif, Long>{
    
    
}