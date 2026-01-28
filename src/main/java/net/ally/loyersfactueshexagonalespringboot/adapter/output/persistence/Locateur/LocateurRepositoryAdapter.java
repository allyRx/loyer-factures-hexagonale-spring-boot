package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.Locateur;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.LocateurEntity;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocateurRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class LocateurRepositoryAdapter implements LocateurRepositoryPort {

    private final LocateurRepository locateurRepository;

    public LocateurRepositoryAdapter(LocateurRepository locateurRepository) {
        this.locateurRepository = locateurRepository;
    }

    @Override
    public Locateur save(Locateur locateur) {
        LocateurEntity locateurEntity = LocateurEntity.fromDomain(locateur);
        LocateurEntity savedLocateur = locateurRepository.save(locateurEntity);

        return LocateurEntity.toDomain(savedLocateur);
    }

    @Override
    public List<Locateur> findAll() {
        return locateurRepository.findAll()
                .stream()
                .map(LocateurEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Locateur> findById(UUID id) {
        return locateurRepository.findById(id).map(LocateurEntity::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        locateurRepository.deleteById(id);
    }
}
