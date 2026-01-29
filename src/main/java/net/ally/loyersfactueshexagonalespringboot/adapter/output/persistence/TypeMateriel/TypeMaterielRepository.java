package net.ally.loyersfactueshexagonalespringboot.adapter.output.persistence.TypeMateriel;

import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.TypeMaterielEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TypeMaterielRepository extends JpaRepository<TypeMaterielEntity, UUID> {
}
