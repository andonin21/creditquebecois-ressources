package qc.ca.creditquebecois.ressources.modele;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Cette classe gère un seul compte
 */
@Document(collection = "comptes")
public class Compte {
    @Id
    private ObjectId id;
    // La position courante du compte private
    @JsonProperty("nomDeCompte")
    String nomDeCompte;
    @JsonProperty("soldeCompte")
    double soldeCompte;
    @JsonProperty("listeTransactions")
    private List<Transaction> listeTransactions;

    // Constructeur
    public Compte(ObjectId id, String nomDeCompte, double soldeCompte, List<Transaction> listeTransactions) {
        this.id = id;
        this.soldeCompte = soldeCompte;
        this.nomDeCompte = nomDeCompte;
        this.listeTransactions = listeTransactions;
    }
    // ajoute une somme à la position courante // et met à jour la date de dernière opération
    public void ajouter(double somme, String typeTransaction, String titreTransaction) {
        soldeCompte += somme;
        this.listeTransactions.add(new Transaction(false, somme, typeTransaction, titreTransaction));
    }
    // retire une somme à la position courante // et met à jour la date de dernière opération
    public void retirer(double somme, String typeTransaction, String titreTransaction) {
        soldeCompte -= somme;
        this.listeTransactions.add(new Transaction(true, somme, typeTransaction, titreTransaction));
    }
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
}