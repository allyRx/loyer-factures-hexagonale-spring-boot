package net.ally.loyersfactueshexagonalespringboot.domain.port.output;

import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BienRepositoryPort {
    Bien save(Bien bien);
    Optional<Bien> findById(UUID id);
    void deleteById(UUID id);
    List<Bien> findAll();
}
