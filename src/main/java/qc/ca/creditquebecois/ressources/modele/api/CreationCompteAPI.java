package qc.ca.creditquebecois.ressources.modele.api;

public class CreationCompteAPI {

    private String nomDeCompte;
    private double sommeInitale;

    public String getNomDeCompte() {
        return nomDeCompte;
    }

    public void setNomDeCompte(String nomDeCompte) {
        this.nomDeCompte = nomDeCompte;
    }

    public double getSommeInitale() {
        return sommeInitale;
    }

    public void setSommeInitale(double sommeInitale) {
        this.sommeInitale = sommeInitale;
    }
}
