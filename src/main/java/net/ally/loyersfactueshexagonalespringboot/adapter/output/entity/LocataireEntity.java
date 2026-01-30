package net.ally.loyersfactueshexagonalespringboot.adapter.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locataire.Locataire;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class LocataireEntity {
    @Id
    private  UUID id;
    private  String name;
    private  String email;
    private  String telephone;
    private  LocalDateTime date_entree;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  List<BienEntity> biens = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TypeMaterielEntity> materiels = new ArrayList<>();

    public static Locataire toDomain(LocataireEntity locataireEntity){
        List<Bien> locataireEntities = new ArrayList<>();

        for(BienEntity bienEntity : locataireEntity.biens){
            Bien bien = new Bien(
                    bienEntity.getId(),
                    bienEntity.getReference(),
                    bienEntity.getAdresse(),
                    bienEntity.getLoyerMensuelle(),
                    bienEntity.isEstDisponible()
            );

            locataireEntities.add(bien);
        }

        List<TypeMateriel> materielTypes = new ArrayList<>();
        for(TypeMaterielEntity typeMaterielEntity : locataireEntity.materiels){
            TypeMateriel typeMateriel = new TypeMateriel(
                    typeMaterielEntity.getId(),
                    typeMaterielEntity.getNom(),
                    typeMaterielEntity.getPrixUnitaire()
            );
            materielTypes.add(typeMateriel);
        }

        return new Locataire(
                locataireEntity.getId(),
                locataireEntity.getName(),
                locataireEntity.getEmail(),
                locataireEntity.getTelephone(),
                locataireEntity.getDate_entree(),
                locataireEntities,
                materielTypes
        );
    }


    public static LocataireEntity fromDomain(Locataire locataire){
       List<BienEntity> locataireEntities = new ArrayList<>();

       for(Bien bienEntity: locataire.getBiens()){
           BienEntity bien = new BienEntity(
                   bienEntity.getId(),
                   bienEntity.getReference(),
                   bienEntity.getAdresse(),
                   bienEntity.getLoyerMensuelle(),
                   bienEntity.isEstDisponible(),
                   null
           );

           locataireEntities.add(bien);
       }

       List<TypeMaterielEntity> materielTypes = new ArrayList<>();
       for(TypeMateriel materiel : locataire.getMateriels()){
           TypeMaterielEntity materielEntity = new TypeMaterielEntity(
                   materiel.getId(),
                   materiel.getNom(),
                   materiel.getPrixUnitaire()
           );
           materielTypes.add(materielEntity);
       }

        return new LocataireEntity(
               locataire.getId(),
               locataire.getName(),
               locataire.getEmail(),
               locataire.getTelephone(),
               locataire.getDate_entree(),
                locataireEntities,
                materielTypes
       );
    }
}
