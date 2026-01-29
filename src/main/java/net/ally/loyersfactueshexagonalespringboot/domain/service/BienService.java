package net.ally.loyersfactueshexagonalespringboot.domain.service;

import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.BienUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.BienRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class BienService implements BienUsecase {

    private final BienRepositoryPort bienRepositoryPort;

    public BienService(BienRepositoryPort bienRepositoryPort) {
        this.bienRepositoryPort = bienRepositoryPort;
    }

    @Override
    public Bien sauvegarderDeBien(String reference, String adresse, double loyerMensuelle, boolean estDisponible) {
        Bien bien = new Bien(reference,adresse,loyerMensuelle,estDisponible);

        return  bienRepositoryPort.save(bien);
    }

    @Override
    public Optional<Bien> recupererBienParId(UUID id) {
        return bienRepositoryPort.findById(id);
    }

    @Override
    public void supprimerDeBien(UUID id) {
        bienRepositoryPort.deleteById(id);
    }

    @Override
    public List<Bien> tousLesBien() {
        return bienRepositoryPort.findAll();
    }

    @Override
    public Bien updateBien(UUID id, String reference, String adresse, double loyerMensuelle, boolean estDisponible) {
        Bien bien = bienRepositoryPort.findById(id).orElseThrow();
        bien.setReference(reference);
        bien.setAdresse(adresse);
        bien.setLoyerMensuelle(loyerMensuelle);
        bien.setEstDisponible(estDisponible);
        return bienRepositoryPort.save(bien);
    }


}
