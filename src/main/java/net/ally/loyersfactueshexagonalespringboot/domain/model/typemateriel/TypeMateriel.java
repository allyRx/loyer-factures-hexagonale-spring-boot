package net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TypeMateriel {
    private UUID id;
    private String nom;
    private double prixUnitaire;

    public TypeMateriel(UUID id, String nom, double prixUnitaire){
        this.id = id;
        this.nom = nom;
        if(prixUnitaire <= 0) throw new IllegalArgumentException("prix_unitaire must be positive");
        this.prixUnitaire = prixUnitaire;
    }

    public TypeMateriel(String nom, double prixUnitaire){
        this.id = UUID.randomUUID();
        this.nom = nom;
        if(prixUnitaire <= 0) throw new IllegalArgumentException("prix_unitaire must be positive");
        this.prixUnitaire = prixUnitaire;
    }
}
