package qc.ca.creditquebecois.ressources.modele;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Transaction {
    @JsonProperty("estNegatif")
    public boolean estNegatif;
    @JsonProperty("montantTransaction")
    public double montantTransaction;
    //Paiment par carte, Prélèvement, Retrait au distributeur, Virement en votre faveur, Frais, Virement émis
    @JsonProperty("typeTransaction")
    private String typeTransaction;
    @JsonProperty("titreTransaction")
    private String titreTransaction;
    @JsonProperty("dateOperation")
    public Date dateOperation;
    public Transaction(boolean estNegatif, double montantTransaction, String typeTransaction, String titreTransaction) {
        this.montantTransaction = montantTransaction;
        this.dateOperation = new Date();
        this.typeTransaction = typeTransaction;
        this.titreTransaction = titreTransaction;
        this.estNegatif = estNegatif;
    }
}