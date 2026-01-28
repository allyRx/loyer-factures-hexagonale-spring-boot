package net.ally.loyersfactueshexagonalespringboot.adapter.output.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;

import java.util.ArrayList;
import java.util.List;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locateur")
    private List<BienEntity> bienEntities = new ArrayList<>();




    public static LocateurEntity fromDomain(Locateur locateur){
        List<BienEntity> bienEntities = new ArrayList<>();

        // 2. Vérifier si le locateur a des biens
        if (locateur.getBiens() != null && !locateur.getBiens().isEmpty()) {
            // 3. Convertir chaque Bien → BienEntity
            for (Bien bien : locateur.getBiens()) {
                BienEntity bienEntity = new BienEntity(
                       bien.getId(),
                        bien.getReference(),
                        bien.getAdresse(),
                        bien.getLoyerMensuelle(),
                        bien.estDisponible(),
                        null
                );
                bienEntities.add(bienEntity);
            }
        }
        return new LocateurEntity(
                locateur.getId(),
                locateur.getName(),
                locateur.getEmail(),
                locateur.getTelephone(),
                bienEntities
        );
    }

    public static Locateur toDomain(LocateurEntity locateurEntity){
        List<Bien> biensDomaine = new ArrayList<>();
        // 2. Vérifier si l'entité a des biens
        if (locateurEntity.getBienEntities() != null && !locateurEntity.getBienEntities().isEmpty()) {

            // 3. Boucle simple : pour chaque BienEntity → créer un Bien
            for (BienEntity bienEntity : locateurEntity.getBienEntities()) {

                // 4. Créer le Bien (domaine) à partir du BienEntity (JPA)
                Bien bien = new Bien(
                        bienEntity.getId(),
                        bienEntity.getReference(),
                        bienEntity.getAdresse(),
                        bienEntity.getLoyerMensuelle(),
                        bienEntity.isEstDisponible()
                );


                biensDomaine.add(bien);
            }
        }
        return new Locateur(
                locateurEntity.getId(),
                locateurEntity.getName(),
                locateurEntity.getEmail(),
                locateurEntity.getTelephone(),
                biensDomaine

        );
    }


}
