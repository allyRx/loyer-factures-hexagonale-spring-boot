package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.Bien;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.BienEntity;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.BienRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BienRepositoryAdapter implements BienRepositoryPort {

    private final BienRepository bienRepository;

    public BienRepositoryAdapter(BienRepository bienRepository) {
        this.bienRepository = bienRepository;
    }

    @Override
    public Bien save(Bien bien) {
        BienEntity bienEntity = BienEntity.fromDomain(bien);
        BienEntity saved = bienRepository.save(bienEntity);
        return BienEntity.toDomain(saved);
    }

    @Override
    public Optional<Bien> findById(UUID id) {
        return bienRepository.findById(id).map(BienEntity::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        bienRepository.deleteById(id);
    }

    @Override
    public List<Bien> findAll() {
        return bienRepository.findAll().stream().map(BienEntity::toDomain).collect(Collectors.toList());
    }
}
