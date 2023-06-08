package qc.ca.creditquebecois.ressources.modele;

import java.util.Date;

public class Position {
    public double solde;
    public Date derniereOperation;
    public Position(double solde) {
        this.solde = solde; this.derniereOperation = new Date();
    }
}