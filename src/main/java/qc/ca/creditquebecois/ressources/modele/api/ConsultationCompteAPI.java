package qc.ca.creditquebecois.ressources.modele.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ConsultationCompteAPI {

    @JsonProperty("nomDeCompte")
    private String nomDeCompte ;

    @JsonProperty("soldeCompte")
    private Double soldeCompte;

    @JsonProperty("transactions")
    private List<TransactionAPI> transactions;
}
