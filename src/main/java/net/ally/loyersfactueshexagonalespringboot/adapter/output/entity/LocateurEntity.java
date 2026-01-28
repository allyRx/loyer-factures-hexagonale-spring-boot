package net.ally.loyersfactueshexagonalespringboot.adapter.output.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;

import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class LocateurEntity {
    @Id
    private UUID id;
    @NonNull
    private String name;
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    private String telephone;


    public static LocateurEntity fromDomain(Locateur locateur){
        return new LocateurEntity(
                locateur.getId(),
                locateur.getName(),
                locateur.getEmail(),
                locateur.getTelephone()
        );
    }

    public static Locateur toDomain(LocateurEntity locateurEntity){
        return new Locateur(
                locateurEntity.getId(),
                locateurEntity.getName(),
                locateurEntity.getEmail(),
                locateurEntity.getTelephone()

        );
    }
}
