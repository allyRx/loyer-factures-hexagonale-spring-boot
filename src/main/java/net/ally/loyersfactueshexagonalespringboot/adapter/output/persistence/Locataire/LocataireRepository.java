package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.Locataire;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.LocataireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocataireRepository extends JpaRepository<LocataireEntity, UUID> {
}
