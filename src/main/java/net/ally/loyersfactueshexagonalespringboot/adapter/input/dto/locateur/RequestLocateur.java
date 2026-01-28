package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locateur;

import lombok.Data;


import java.util.List;
import java.util.UUID;

@Data
public class RequestLocateur {
    private String name;
    private String email;
    private String telephone;
    private List<UUID> biens;
}
