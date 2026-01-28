package net.ally.loyersfactueshexagonalespringboot.domain.service;

import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locateur.Locateur;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocateurUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocateurRepositoryPort;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class LocateurService implements LocateurUsecase {

    private final  LocateurRepositoryPort locateurRepositoryPort;

    public LocateurService(LocateurRepositoryPort locateurRepositoryPort) {
        this.locateurRepositoryPort = locateurRepositoryPort;
    }

    @Override
    public Locateur sauvegarderLocateur(String name, String email, String telephone, List<Bien> bien) {
        Locateur locateur = new Locateur(name,email,telephone,bien);
        return locateurRepositoryPort.save(locateur);
    }

    @Override
    public List<Locateur> recupererToutLocateur() {
        return locateurRepositoryPort.findAll();
    }

    @Override
    public Optional<Locateur> recupererLocateurParId(UUID id) {
        return locateurRepositoryPort.findById(id);
    }

    @Override
    public void supprimerLocateur(UUID id) {
        locateurRepositoryPort.deleteById(id);
    }
}
