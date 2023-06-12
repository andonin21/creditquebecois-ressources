package qc.ca.creditquebecois.ressources.modele;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * The type Transaction.
 */
public class Transaction {

    /**
     * The Est negatif.
     */
    @JsonProperty("estNegatif")
    public boolean estNegatif;
    /**
     * Montant de la transaction.
     */
    @JsonProperty("montantTransaction")
    public double montantTransaction;
    //Paiment par carte, Prélèvement, Retrait au distributeur, Virement en votre faveur, Frais, Virement émis, Chèque en votre faveur, Chèque émis
    @JsonProperty("typeTransaction")
    private String typeTransaction;
    @JsonProperty("titreTransaction")
    private String titreTransaction;
    /**
     * Date de l'operation.
     */
    @JsonProperty("dateOperation")
    public Date dateOperation;

    /**
     * Instantiates a new Transaction.
     *
     * @param estNegatif         est negatif
     * @param montantTransaction montant de la transaction
     * @param typeTransaction    type de la transaction
     * @param titreTransaction   titre de la transaction
     */
    public Transaction(boolean estNegatif, double montantTransaction, String typeTransaction, String titreTransaction) {
        this.montantTransaction = montantTransaction;
        this.dateOperation = new Date();
        this.typeTransaction = typeTransaction;
        this.titreTransaction = titreTransaction;
        this.estNegatif = estNegatif;
    }
}