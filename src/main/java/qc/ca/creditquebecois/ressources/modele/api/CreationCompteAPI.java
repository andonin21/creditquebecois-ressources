package qc.ca.creditquebecois.ressources.modele.api;

public class CreationCompteAPI {

    private String nomDeCompte;
    private double sommeInitiale;

    public String getNomDeCompte() {
        return nomDeCompte;
    }

    public void setNomDeCompte(String nomDeCompte) {
        this.nomDeCompte = nomDeCompte;
    }

    public Double getSommeInitiale() {
        return sommeInitiale;
    }

    public void setSommeInitiale(int sommeInitale) {
        this.sommeInitiale = sommeInitale;
    }
}
