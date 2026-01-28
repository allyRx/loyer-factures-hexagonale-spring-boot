package net.ally.loyersfactueshexagonalespringboot.domain.model.locateur;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import java.util.UUID;

@Getter
public class Locateur {

    private final UUID id;
    private final String name;
    private final String email;
    private final String telephone;

    public Locateur(UUID id,String name, String email, String telephone) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public Locateur(String name, String email, String telephone) {
        this.id= UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

}
