package net.ally.loyersfactueshexagonalespringboot.adapter.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;

import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class BienEntity {

    @Id
    private UUID id;
    @Column(unique = true)
    private String reference;
    private String adresse;
    private double loyerMensuelle;
    private boolean estDisponible;


    public static BienEntity fromDomain(Bien bien) {
        return new BienEntity(
                bien.getId(),
                bien.getReference(),
                bien.getAdresse(),
                bien.getLoyerMensuelle(),
                bien.estDisponible()
        );
    }

    public static Bien toDomain(BienEntity bienEntity){
        return new Bien(
                bienEntity.getId(),
                bienEntity.getReference(),
                bienEntity.getAdresse(),
                bienEntity.getLoyerMensuelle(),
                bienEntity.estDisponible
        );
    }

}
