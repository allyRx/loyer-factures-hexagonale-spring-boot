package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.typemateriel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class TypeMaterielResponseDto {
    private String id_type_materiel;
    private String nom;
    private double prixUnitaire;
}
