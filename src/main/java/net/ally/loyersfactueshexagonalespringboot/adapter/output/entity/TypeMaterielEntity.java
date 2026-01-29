package net.ally.loyersfactueshexagonalespringboot.adapter.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;

import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class TypeMaterielEntity {

    @Id
    private UUID id;

    @Column(unique = true)
    private String nom;

    private double prixUnitaire;

    public static TypeMaterielEntity fromDomain(TypeMateriel t){
        return new TypeMaterielEntity(t.getId(), t.getNom(), t.getPrixUnitaire());
    }

    public static TypeMateriel toDomain(TypeMaterielEntity e){
        return new TypeMateriel(e.getId(), e.getNom(), e.getPrixUnitaire());
    }
}
