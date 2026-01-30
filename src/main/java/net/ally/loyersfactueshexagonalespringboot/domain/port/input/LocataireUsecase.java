package net.ally.loyersfactueshexagonalespringboot.domain.port.input;

import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locataire.Locataire;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocataireUsecase {
    Locataire ajouterLocataire(String name, String email, String telephone, LocalDateTime date_entree, List<Bien> biens, List<TypeMateriel> materiels);
    Optional<Locataire> recupererLocateurParId(UUID id);
    List<Locataire> recupererLocateurs();
    void supprimerLocateur(UUID id);
}
