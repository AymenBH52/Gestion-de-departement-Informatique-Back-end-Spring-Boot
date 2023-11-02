package com.projet_soa.gestion_departement_info.services;

import java.util.List;

import com.projet_soa.gestion_departement_info.entities.CadreAdministratif;

public interface CadreAdministratifService {

    List<CadreAdministratif> getAllCadreAdministratifs();
    CadreAdministratif getCadreAdministratifById(Long id);
    CadreAdministratif saveCadreAdministratif(CadreAdministratif cadreAdministratif);
    CadreAdministratif updateCadreAdministratif(Long id, CadreAdministratif cadreAdministratif);
    void deleteCadreAdministratifById(Long id);
    
}