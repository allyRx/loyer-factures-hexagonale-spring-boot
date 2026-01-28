package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.bien;

import lombok.Data;

@Data
public class RequestDto {
    private String reference;
    private String adresse;
    private double loyerMensuelle;
    private boolean estDisbonible;
}
