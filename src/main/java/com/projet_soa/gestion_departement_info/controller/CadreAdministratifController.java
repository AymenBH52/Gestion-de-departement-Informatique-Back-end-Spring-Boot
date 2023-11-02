package com.projet_soa.gestion_departement_info.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet_soa.gestion_departement_info.entities.CadreAdministratif;
import com.projet_soa.gestion_departement_info.services.CadreAdministratifService;

@RestController
@RequestMapping("/cadre-administratif")
public class CadreAdministratifController {

    @Autowired
    private CadreAdministratifService cadAdSer;


    @GetMapping("/")
    public List<CadreAdministratif> getAllCadreAdministratifs() {
        return cadAdSer.getAllCadreAdministratifs();
    }

    @GetMapping("/{id}")
    public CadreAdministratif getCadreAdministratifById(@PathVariable Long id) {
        return cadAdSer.getCadreAdministratifById(id);
    }

    @PostMapping("/")
    public CadreAdministratif saveCadreAdministratif(@RequestBody CadreAdministratif cadreAdministratif) {
        return cadAdSer.saveCadreAdministratif(cadreAdministratif);
    }

    @PutMapping("/{id}")
    public CadreAdministratif updateCadreAdministratif(@PathVariable Long id, @RequestBody CadreAdministratif cadreAdministratif) {
        return cadAdSer.updateCadreAdministratif(id, cadreAdministratif);
    }

    @DeleteMapping("/{id}")
    public void deleteCadreAdministratifById(@PathVariable Long id) {
        cadAdSer.deleteCadreAdministratifById(id);
    }
}