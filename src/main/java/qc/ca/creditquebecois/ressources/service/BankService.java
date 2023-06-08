package qc.ca.creditquebecois.ressources.service;

import qc.ca.creditquebecois.ressources.modele.Compte;
import qc.ca.creditquebecois.ressources.repository.CompteRepository;
import qc.ca.creditquebecois.ressources.tools.CreditQuebecoisTools;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Service
@AllArgsConstructor
public class BankService {
    private final CompteRepository compteRepository;
    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    public void creerCompte(String nomDeCompte, double sommeInitiale) {
        Compte compte = new Compte(nomDeCompte, sommeInitiale);
        compteRepository.save(compte);
    }

    public Compte consulterCompte(String idCompte) {
        ObjectId idCompteObject = new ObjectId(idCompte);
        Optional<Compte> compte = compteRepository.findById(idCompteObject);
        return compte.get();
    }

    public void ajouterArgent(String idCompte, double sommeAAjouter) {
        ObjectId idCompteObject = new ObjectId(idCompte);
        Optional<Compte> compte = compteRepository.findById(idCompteObject);
        compte.get().ajouter(sommeAAjouter);
    }

    public void retirerArgent(String idCompte, double sommeARetirer) {
        ObjectId idCompteObject = new ObjectId(idCompte);
        Optional<Compte> compte = compteRepository.findById(idCompteObject);
        compte.get().ajouter(sommeARetirer);
    }
}
