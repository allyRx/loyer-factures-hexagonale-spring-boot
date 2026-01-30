package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locataire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor @NoArgsConstructor @Data
public class ResponseDto {
    private String id;
    private  String name;
    private  String email;
    private  String telephone;
    private LocalDateTime date_entree;
    private List<Bien> biens;
    private List<TypeMateriel> materiels;
}
