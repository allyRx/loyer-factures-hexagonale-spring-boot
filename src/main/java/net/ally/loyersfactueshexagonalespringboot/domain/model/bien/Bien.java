package net.ally.loyersfactueshexagonalespringboot.domain.model.bien;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Bien {
    private UUID id;
    private String reference;
    private String adresse;
    private double loyerMensuelle;
    private boolean estDisponible;

    public Bien(UUID id, String reference, String adresse,  double loyerMensuelle, boolean estDisponible){
        this.id= id;
        this.reference= reference;
        this.adresse= adresse;
        this.loyerMensuelle=loyerMensuelle;
        this.estDisponible = estDisponible;
    }


    public Bien(String reference, String adresse,  double loyerMensuelle , boolean estDisponible){
        this.id= UUID.randomUUID();
        this.reference= reference;
        this.adresse= adresse;
        this.loyerMensuelle=loyerMensuelle;
        this.estDisponible = estDisponible;
    }



    //Logique metier
    public boolean estDisponible(){
        return !this.estDisponible;
    }

}
