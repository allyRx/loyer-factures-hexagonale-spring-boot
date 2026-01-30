package net.ally.loyersfactueshexagonalespringboot.domain.model.locataire;

import lombok.Getter;
import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Locataire {
    private final UUID id;
    private final String name;
    private final String email;
    private final String telephone;
    private final LocalDateTime  date_entree;
    private final List<Bien> biens;
    private final List<TypeMateriel> materiels;

    public Locataire(UUID id, String name, String email, String telephone, LocalDateTime dateEntree, List<Bien> biens, List<TypeMateriel> materiels) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        date_entree = dateEntree;
        this.biens = biens;
        this.materiels = materiels;
    }

    public Locataire(String name, String email, String telephone, LocalDateTime dateEntree, List<Bien> biens, List<TypeMateriel> materiels) {
        this.materiels = materiels;
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        date_entree = dateEntree;
        this.biens = biens;
    }
}
