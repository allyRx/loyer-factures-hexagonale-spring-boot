package net.ally.loyersfactueshexagonalespringboot.domain.service;

import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locataire.Locataire;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocataireUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocataireRepositryPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LocataireService implements LocataireUsecase {

    private final LocataireRepositryPort locataireRepositoryPort;

    public LocataireService(LocataireRepositryPort locataireRepositoryPort) {
        this.locataireRepositoryPort = locataireRepositoryPort;
    }


    @Override
    public Locataire ajouterLocataire(String name, String email, String telephone, LocalDateTime date_entree, List<Bien> biens) {
        Locataire locataire = new Locataire(name,email,telephone,date_entree,biens);
        return locataireRepositoryPort.save(locataire);
    }

    @Override
    public Optional<Locataire> recupererLocateurParId(UUID id) {
        return locataireRepositoryPort.findLocataireById(id);
    }

    @Override
    public List<Locataire> recupererLocateurs() {
        return locataireRepositoryPort.findAllLocataires();
    }

    @Override
    public void supprimerLocateur(UUID id) {
        locataireRepositoryPort.deleteById(id);
    }
}
