package net.ally.loyersfactueshexagonalespringboot.domain.port.output;

import net.ally.loyersfactueshexagonalespringboot.domain.model.locataire.Locataire;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocataireRepositryPort {
    Locataire save(Locataire locataire);
    Optional<Locataire> findLocataireById(UUID id);
    List<Locataire> findAllLocataires();
    void deleteById(UUID id);
}
