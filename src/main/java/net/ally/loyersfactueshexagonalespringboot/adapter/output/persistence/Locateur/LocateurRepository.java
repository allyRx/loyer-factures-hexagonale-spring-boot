package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.Locateur;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.LocateurEntity;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LocateurRepository extends JpaRepository<LocateurEntity , UUID> {
    Optional<Locateur> findByEmail(String email);
}
