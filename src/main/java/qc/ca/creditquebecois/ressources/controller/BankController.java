package qc.ca.creditquebecois.ressources.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qc.ca.creditquebecois.ressources.modele.Compte;
import qc.ca.creditquebecois.ressources.modele.api.*;
import qc.ca.creditquebecois.ressources.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banque")
public class BankController {
    private final BankService bankService;
    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/creerCompte")
    public String creerCompte(@RequestBody CreationCompteAPI creationCompte) {
        // Logique pour permettre à un client de créer un compte
        logger.info("" + creationCompte.getSommeInitiale());
        return bankService.creerCompte(creationCompte.getNomDeCompte(), creationCompte.getSommeInitiale());
    }

    @GetMapping("/{idCompte}/consulterCompte")
    public Compte consulterCompte(@PathVariable String idCompte) {
        // Logique pour permettre à un client de consulter l'argent sur son compte
        return bankService.consulterCompte(idCompte);
    }

    @PostMapping("/{idCompte}/ajouterArgent")
    public void ajouterArgent(@PathVariable String idCompte, @RequestBody RequeteTransactionAPI transactionCompte) {
        // Logique pour permettre à un client d'ajouter de l'argent sur son compte
        bankService.ajouterArgent(idCompte, transactionCompte.getSomme(), transactionCompte.getTypeTransaction(), transactionCompte.getTitreTransaction());
    }

    @PostMapping("/{idCompte}/retirerArgent")
    public void retirerArgent(@PathVariable String idCompte, @RequestBody RequeteTransactionAPI transactionCompte) {
        // Logique pour permettre à un client de retirer de l'argent sur son compte
        bankService.retirerArgent(idCompte, transactionCompte.getSomme(), transactionCompte.getTypeTransaction(), transactionCompte.getTitreTransaction());
    }
}