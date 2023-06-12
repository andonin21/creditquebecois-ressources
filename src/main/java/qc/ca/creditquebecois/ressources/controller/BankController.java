package qc.ca.creditquebecois.ressources.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qc.ca.creditquebecois.ressources.modele.Compte;
import qc.ca.creditquebecois.ressources.modele.api.*;
import qc.ca.creditquebecois.ressources.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The type Bank controller.
 */
@RestController
@RequestMapping("/banque")
public class BankController {

    private final BankService bankService;
    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    /**
     * Instantiates a new Bank controller.
     *
     * @param bankService  bank service
     */
    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    /**
     *La méthode permet à un client de créer un compte
     * @param creationCompte Creer un compte
     * @return string
     */
    @PostMapping("/creerCompte")
    public String creerCompte(@RequestBody CreationCompteAPI creationCompte) {
        // Logique pour permettre à un client de créer un compte
        logger.info("" + creationCompte.getSommeInitiale());
        return bankService.creerCompte(creationCompte.getNomDeCompte(), creationCompte.getSommeInitiale());
    }

    /**
     * La méthode permet à un client de consulter l'argent sur son compte.
     * @param idCompte id du compte
     * @return compte
     */
    @GetMapping("/{idCompte}/consulterCompte")
    public Compte consulterCompte(@PathVariable String idCompte) {
        // Logique pour permettre à un client de consulter l'argent sur son compte
        return bankService.consulterCompte(idCompte);
    }

    /**
     * La méthode permet à un client d'ajouter de l'argent sur son compte
     * @param idCompte          id du compte
     * @param transactionCompte transaction effectuer sur compte
     */
    @PostMapping("/{idCompte}/ajouterArgent")
    public void ajouterArgent(@PathVariable String idCompte, @RequestBody RequeteTransactionAPI transactionCompte) {
        // Logique pour permettre à un client d'ajouter de l'argent sur son compte
        bankService.ajouterArgent(idCompte, transactionCompte.getSomme(), transactionCompte.getTypeTransaction(), transactionCompte.getTitreTransaction());
    }

    /**
     * La méthode permet à un client de retirer de l'argent de son compte
     * @param idCompte id du compte
     * @param transactionCompte  transaction effectuer compte
     */
    @PostMapping("/{idCompte}/retirerArgent")
    public void retirerArgent(@PathVariable String idCompte, @RequestBody RequeteTransactionAPI transactionCompte) {
        // Logique pour permettre à un client de retirer de l'argent sur son compte
        bankService.retirerArgent(idCompte, transactionCompte.getSomme(), transactionCompte.getTypeTransaction(), transactionCompte.getTitreTransaction());
    }
}