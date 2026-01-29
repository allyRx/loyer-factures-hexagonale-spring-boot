package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.typemateriel;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Data
public class TypeMaterielRequestDto {
    @NotBlank(message = "nom is required")
    private String nom;

    @Positive(message = "prix_unitaire must be positive")
    private double prixUnitaire;
}
