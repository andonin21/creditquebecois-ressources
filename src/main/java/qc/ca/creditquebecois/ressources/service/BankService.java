package qc.ca.creditquebecois.ressources.service;

import qc.ca.creditquebecois.ressources.modele.Compte;
import qc.ca.creditquebecois.ressources.repository.CompteRepository;
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

    public String creerCompte(String nomDeCompte, double sommeInitiale) {
        ObjectId idCompteObject = new ObjectId();
        List listeTransactions = new ArrayList();
        Compte compte = new Compte(idCompteObject, nomDeCompte, sommeInitiale, listeTransactions);
        compteRepository.save(compte);
        return compte.getId().toString();
    }

    public Compte consulterCompte(String idCompte) {
        ObjectId idCompteObject = new ObjectId(idCompte);
        Optional<Compte> compte = compteRepository.findById(idCompteObject);
        return compte.get();
    }

    public void ajouterArgent(String idCompte, double sommeAAjouter, String typeTransaction, String titreTransaction) {
        ObjectId idCompteObject = new ObjectId(idCompte);
        Optional<Compte> compteOptionnel = compteRepository.findById(idCompteObject);
        if(compteOptionnel.isPresent()){
            Compte compte = compteOptionnel.get();
            compte.ajouter(sommeAAjouter, typeTransaction, titreTransaction);
            compteRepository.save(compte);
        }
    }

    public void retirerArgent(String idCompte, double sommeARetirer, String typeTransaction, String titreTransaction) {
        ObjectId idCompteObject = new ObjectId(idCompte);
        Optional<Compte> compteOptionnel = compteRepository.findById(idCompteObject);
        if(compteOptionnel.isPresent()){
            Compte compte = compteOptionnel.get();
            compte.retirer(sommeARetirer, typeTransaction, titreTransaction);
            compteRepository.save(compte);
        }
    }
}
