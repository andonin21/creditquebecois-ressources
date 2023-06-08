package qc.ca.creditquebecois.ressources.modele.api;

public class RequeteTransactionAPI {

    private String typeTransaction;
    private String titreTransaction;
    private double somme;

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getTitreTransaction() {
        return titreTransaction;
    }

    public void setTitreTransaction(String titreTransaction) {
        this.titreTransaction = titreTransaction;
    }

}
