package net.ally.loyersfactueshexagonalespringboot.domain.port.input;

import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BienUsecase {
    Bien sauvegarderDeBien(String reference, String adresse , double loyerMensuelle, boolean estDisponible);
    Optional<Bien> recupererBienParId(UUID id);
    void supprimerDeBien(UUID id);
    List<Bien> tousLesBien();
}
