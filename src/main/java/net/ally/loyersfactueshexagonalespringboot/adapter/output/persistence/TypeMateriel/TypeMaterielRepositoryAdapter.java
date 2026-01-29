package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.TypeMateriel;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.TypeMaterielEntity;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.TypeMaterielRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TypeMaterielRepositoryAdapter implements TypeMaterielRepositoryPort {

    private final TypeMaterielRepository repository;

    public TypeMaterielRepositoryAdapter(TypeMaterielRepository repository) {
        this.repository = repository;
    }

    @Override
    public TypeMateriel save(TypeMateriel typeMateriel) {
        TypeMaterielEntity entity = TypeMaterielEntity.fromDomain(typeMateriel);
        TypeMaterielEntity saved = repository.save(entity);
        return TypeMaterielEntity.toDomain(saved);
    }

    @Override
    public Optional<TypeMateriel> findById(UUID id) {
        return repository.findById(id).map(TypeMaterielEntity::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<TypeMateriel> findAll() {
        return repository.findAll().stream()
                .map(TypeMaterielEntity::toDomain)
                .collect(Collectors.toList());
    }
}
