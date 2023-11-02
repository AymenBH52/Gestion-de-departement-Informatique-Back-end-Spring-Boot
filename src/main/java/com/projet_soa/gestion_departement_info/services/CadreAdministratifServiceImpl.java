package com.projet_soa.gestion_departement_info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_soa.gestion_departement_info.dao.CadreAdministratifRepository;
import com.projet_soa.gestion_departement_info.entities.CadreAdministratif;

@Service
public class CadreAdministratifServiceImpl implements CadreAdministratifService {

    @Autowired
    private CadreAdministratifRepository cadreAdministratifRepository;

    @Override
    public List<CadreAdministratif> getAllCadreAdministratifs() {
        return cadreAdministratifRepository.findAll();
    }

    @Override
    public CadreAdministratif getCadreAdministratifById(Long id) {
        return cadreAdministratifRepository.findById(id).get();
    }

    @Override
    public CadreAdministratif saveCadreAdministratif(CadreAdministratif cadreAdministratif) {
        return cadreAdministratifRepository.save(cadreAdministratif);
    }

    @Override
    public CadreAdministratif updateCadreAdministratif(Long id, CadreAdministratif updatedcadreAdministratif) {
        CadreAdministratif oldCadreAdministratif = cadreAdministratifRepository.findById(id).get();
        oldCadreAdministratif.setNom(updatedcadreAdministratif.getNom());
        oldCadreAdministratif.setPrenom(updatedcadreAdministratif.getPrenom());
        oldCadreAdministratif.setEmail(updatedcadreAdministratif.getEmail());
        oldCadreAdministratif.setTelephone(updatedcadreAdministratif.getTelephone());
        oldCadreAdministratif.setPoste(updatedcadreAdministratif.getPoste());
        return cadreAdministratifRepository.save(oldCadreAdministratif);

    }

    @Override
    public void deleteCadreAdministratifById(Long id) {
        cadreAdministratifRepository.deleteById(id);
    }




    
}