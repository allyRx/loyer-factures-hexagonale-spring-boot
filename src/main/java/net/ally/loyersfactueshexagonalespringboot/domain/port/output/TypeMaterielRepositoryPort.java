package net.ally.loyersfactueshexagonalespringboot.domain.port.output;

import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TypeMaterielRepositoryPort {
    TypeMateriel save(TypeMateriel typeMateriel);
    Optional<TypeMateriel> findById(UUID id);
    void deleteById(UUID id);
    List<TypeMateriel> findAll();
}
