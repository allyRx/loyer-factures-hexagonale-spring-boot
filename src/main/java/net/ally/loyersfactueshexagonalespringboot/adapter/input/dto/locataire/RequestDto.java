package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locataire;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class RequestDto {
    private  String name;
    private  String email;
    private  String telephone;
    private  LocalDateTime date_entree;
    private  List<UUID> biens;
    private List<UUID> materiels;
}
