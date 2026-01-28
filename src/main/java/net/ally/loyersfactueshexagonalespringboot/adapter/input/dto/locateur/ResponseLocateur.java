package net.ally.loyersfactueshexagonalespringboot.adapter.input.dto.locateur;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseLocateur {
    private String id;
    private String name;
    private String email;
    private String telephone;
}
