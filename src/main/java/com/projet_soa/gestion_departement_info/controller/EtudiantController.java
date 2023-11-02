package com.projet_soa.gestion_departement_info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet_soa.gestion_departement_info.entities.Etudiant;
import com.projet_soa.gestion_departement_info.services.EtudiantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.findById(id);
    }

    @PostMapping("")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.add(etudiant);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        return etudiantService.update(id, etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.delete(id);

    }

    @GetMapping("/etudiant/{etudiantId}/absences")
    public Integer getNumberOfAbsencesByEtudiantId(@PathVariable Long etudiantId) {
        return etudiantService.getNumberOfAbsencesByEtudiantId(etudiantId);
    }

    @PostMapping("/etudiant/{etudiantId}/absences")
    public void addAbsence(@PathVariable Long etudiantId) {
        etudiantService.addAbsence(etudiantId);
    }

    @DeleteMapping("/etudiant/{etudiantId}/absences")
    public void removeAbsence(@PathVariable Long etudiantId) {
        etudiantService.removeAbsence(etudiantId);
    }

    @GetMapping("/taux-absentisme")
    public Double getTauxAbsenteisme() {
        return etudiantService.getTauxAbsenteisme();
    }

    @GetMapping("/taux-reussite")
    public Double getTauxReussite() {
        return etudiantService.getTauxReussite();
    }

    @GetMapping("/a-reussi/{id}")
    public Boolean Reussi(@PathVariable Long id) {
        return etudiantService.Reussi(etudiantService.findById(id));
    }
}
