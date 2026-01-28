package net.ally.loyersfactueshexagonalespringboot.domain.port.output;

import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocateurRepositoryPort {
    Locateur save(Locateur locateur);
    List<Locateur> findAll();
    Optional<Locateur> findById(UUID id);
    void deleteById(UUID id);
}
