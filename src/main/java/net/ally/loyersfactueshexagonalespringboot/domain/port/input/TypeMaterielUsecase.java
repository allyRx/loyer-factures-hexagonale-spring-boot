package net.ally.loyersfactueshexagonalespringboot.domain.port.input;

import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TypeMaterielUsecase {
    TypeMateriel sauvegarderTypeMateriel(String nom, double prixUnitaire);
    Optional<TypeMateriel> recupererParId(UUID id);
    void supprimerTypeMateriel(UUID id);
    List<TypeMateriel> tousLesTypeMateriels();
    TypeMateriel updateTypeMateriel(UUID id, String nom, double prixUnitaire);
}
