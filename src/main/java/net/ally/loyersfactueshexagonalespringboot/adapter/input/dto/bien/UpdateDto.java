package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.bien;

import lombok.Data;

@Data
public class UpdateDto {
    private String reference;
    private String adresse;
    private double loyerMensuelle;
    private boolean estDisbonible;
}
