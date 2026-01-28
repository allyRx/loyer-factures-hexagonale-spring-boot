package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.bien;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor
public class ResponseDto {
    private String id;
    private String reference;
    private String adresse;
    private double loyerMensuelle;
    private boolean estDisbonible;
}
