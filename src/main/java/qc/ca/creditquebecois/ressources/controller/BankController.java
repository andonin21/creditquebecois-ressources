package qc.ca.creditquebecois.ressources.controller;

import qc.ca.creditquebecois.ressources.modele.Compte;
import qc.ca.creditquebecois.ressources.modele.api.*;
import qc.ca.creditquebecois.ressources.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banque")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/creerCompte")
    public void creerCompte(@RequestBody CreationCompteAPI creationCompte) {
        // Logique pour permettre à un client de créer un compte
        bankService.creerCompte(creationCompte.getNomDeCompte(), creationCompte.getSommeInitale());
    }

    @GetMapping("/{idCompte}/consulterCompte")
    public Compte consulterCompte(@PathVariable String idCompte) {
        // Logique pour permettre à un client de consulter l'argent sur son compte
        return bankService.consulterCompte(idCompte);
    }

    @PostMapping("/{idCompte}/ajouterArgent")
    public void ajouterArgent(@PathVariable String idCompte, @RequestBody double sommeAAjouter) {
        // Logique pour permettre à un client d'ajouter de l'argent sur son compte
        bankService.ajouterArgent(idCompte,sommeAAjouter);
    }

    @PostMapping("/{idCompte}/retirerArgent")
    public void retirerArgent(@PathVariable String idCompte, @RequestBody double sommeARetirer) {
        // Logique pour permettre à un client de retirer de l'argent sur son compte
        bankService.retirerArgent(idCompte,sommeARetirer);
    }
}