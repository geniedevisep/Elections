package sn.edu.isepdiamniadio.dbe.GestionElection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Candidate;
import sn.edu.isepdiamniadio.dbe.GestionElection.model.Electeur;
import sn.edu.isepdiamniadio.dbe.GestionElection.service.ElecteurService;

import java.util.List;

@RestController
@RequestMapping("/api/electeur")
public class ElecteurController {
    @Autowired
    private ElecteurService electeurService;

    @GetMapping
    public ResponseEntity<List<Electeur>> getAllElecteur() {
        List<Electeur> electeurs = electeurService.getElecteurs();
        return ResponseEntity.ok(electeurs);
    }

    @GetMapping("/{id}")
    public Electeur getElecteur(@PathVariable String id) {
        return electeurService.findElecteur(id);
    }

    @PostMapping
    public Electeur ajouterElecteur(@RequestBody Electeur electeur) {
        return electeurService.ajouterElecteur(electeur);
    }

    @PutMapping("/{id}")
    public void mettreAjourElecteur( @RequestBody Electeur electeur) {
        electeurService.editElecteur(electeur);
    }

    @DeleteMapping("/{id}")
    public void supprimerElecteur(@PathVariable String id) {
        electeurService.supprimerElecteur(id);
    }



    }


