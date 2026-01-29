package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.Locataire;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.LocataireEntity;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locataire.Locataire;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocataireRepositryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class LocataireRepositoryAdapter implements LocataireRepositryPort {

    private final LocataireRepository locataireRepository;

    public LocataireRepositoryAdapter(LocataireRepository locataireRepository) {
        this.locataireRepository = locataireRepository;
    }

    @Override
    public Locataire save(Locataire locataire) {
        LocataireEntity locataireEntity = LocataireEntity.fromDomain(locataire);
        LocataireEntity locataireEntitySaved =locataireRepository.save(locataireEntity);
        return  LocataireEntity.toDomain(locataireEntitySaved);
    }

    @Override
    public Optional<Locataire> findLocataireById(UUID id) {
        return locataireRepository.findById(id).map(LocataireEntity::toDomain);
    }

    @Override
    public List<Locataire> findAllLocataires() {
        return locataireRepository.findAll().stream().map(LocataireEntity::toDomain).toList();
    }

    @Override
    public void deleteById(UUID id) {
        locataireRepository.deleteById(id);
    }
}
