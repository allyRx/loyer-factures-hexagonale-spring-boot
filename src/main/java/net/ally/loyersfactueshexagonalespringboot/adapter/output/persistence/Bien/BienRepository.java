package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.Bien;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.BienEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BienRepository extends JpaRepository<BienEntity , UUID> {
}
