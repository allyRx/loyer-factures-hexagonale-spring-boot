package net.ally.loyersfactueshexagonalespringboot.domain.model.locateur;

import lombok.Getter;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Locateur {

    private final UUID id;
    private final String name;
    private final String email;
    private final String telephone;
    private final List<Bien> biens;

    public Locateur(UUID id, String name, String email, String telephone, List<Bien> biens) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.biens = biens !=null ? biens : new ArrayList<>();
    }

    public Locateur(String name, String email, String telephone, List<Bien> biens) {
        this.id= UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.biens = biens !=null ? biens : new ArrayList<>();
    }


}
