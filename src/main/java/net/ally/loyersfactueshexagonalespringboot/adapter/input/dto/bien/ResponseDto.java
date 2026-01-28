package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.bien;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ally.loyersfactueshexagonalespringboot.adapter.output.entity.BienEntity;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ResponseDto {
    private String id;
    private String reference;
    private String adresse;
    private double loyerMensuelle;
    private boolean estDisbonible;
}
