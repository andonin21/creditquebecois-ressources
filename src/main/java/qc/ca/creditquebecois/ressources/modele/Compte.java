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
    /**
     *  Nom du compte.
     */
// La position courante du compte private
    @JsonProperty("nomDeCompte")
    String nomDeCompte;
    /**
     *  Solde du compte.
     */
    @JsonProperty("soldeCompte")
    double soldeCompte;
    @JsonProperty("listeTransactions")
    private List<Transaction> listeTransactions;

    // Constructeur

    /**
     * Instantiates a new Compte.
     *
     * @param id                id du compte
     * @param nomDeCompte       nom du compte
     * @param soldeCompte       solde du compte
     * @param listeTransactions liste des transactions
     */
    public Compte(ObjectId id, String nomDeCompte, double soldeCompte, List<Transaction> listeTransactions) {
        this.id = id;
        this.soldeCompte = soldeCompte;
        this.nomDeCompte = nomDeCompte;
        this.listeTransactions = listeTransactions;
    }
    // ajoute une somme à la position courante // et met à jour la date de dernière opération

    /**
     * Ajouter.
     *
     * @param somme            La somme
     * @param typeTransaction  le type de la transaction
     * @param titreTransaction le titre de la transaction
     */
    public void ajouter(double somme, String typeTransaction, String titreTransaction) {
        soldeCompte += somme;
        this.listeTransactions.add(new Transaction(false, somme, typeTransaction, titreTransaction));
    }
    // retire une somme à la position courante // et met à jour la date de dernière opération

    /**
     * Retirer.
     *
     * @param somme            La somme
     * @param typeTransaction  le type de la transaction
     * @param titreTransaction le titre de la transaction
     */
    public void retirer(double somme, String typeTransaction, String titreTransaction) {
        soldeCompte -= somme;
        this.listeTransactions.add(new Transaction(true, somme, typeTransaction, titreTransaction));
    }

    /**
     * Gets id.
     *
     * @return id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
}