package net.ally.loyersfactueshexagonalespringboot.domain.port.input;

import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocateurUsecase {
    Locateur sauvegarderLocateur(String name , String email, String telephone);
    List<Locateur> recupererToutLocateur();
    Optional<Locateur> recupererLocateurParId(UUID id);
    void supprimerLocateur(UUID id);
}
