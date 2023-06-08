package qc.ca.creditquebecois.ressources.modele.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionAPI {

    @JsonProperty("estNegatif")
    private Boolean estNegatif;

    @JsonProperty("montantTransaction")
    private Double montantTransaction;

    @JsonProperty("typeTransaction")
    private String typeTransaction;

    @JsonProperty("titreTransaction")
    private String titreTransaction;

    @JsonProperty("dateOperation")
    private String dateOperation;
}
