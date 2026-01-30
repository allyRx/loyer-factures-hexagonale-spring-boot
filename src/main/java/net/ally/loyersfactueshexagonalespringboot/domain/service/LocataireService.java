package net.ally.loyersfactueshexagonalespringboot.domain.service;

import net.ally.loyersfactueshexagonalespringboot.domain.model.bien.Bien;
import net.ally.loyersfactueshexagonalespringboot.domain.model.locataire.Locataire;
import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocataireUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.BienRepositoryPort;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocataireRepositryPort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LocataireService implements LocataireUsecase {

    private final LocataireRepositryPort locataireRepositoryPort;
    private final BienRepositoryPort bienRepositoryPort;


    public LocataireService(LocataireRepositryPort locataireRepositoryPort, BienRepositoryPort bienRepositoryPort) {
        this.locataireRepositoryPort = locataireRepositoryPort;

        this.bienRepositoryPort = bienRepositoryPort;
    }


    @Override
    public Locataire ajouterLocataire(String name, String email, String telephone, LocalDateTime date_entree, List<Bien> biens,List<TypeMateriel> materiels) {

        //verification si bien est dispo
        List<Bien> bienFinal = new ArrayList<>();


        for (Bien bien : biens) {
            if(bien.estDisponible()){
                bienFinal.add(bien);
                 bien.setEstDisponible(false);
                 bienRepositoryPort.save(bien); //mettre le bien en false
            }
        }

        if(bienFinal.isEmpty()){
            return null;
        }

        List<TypeMateriel> Materiels = new ArrayList<>(materiels);

        Locataire locataire = new Locataire(name,email,telephone,date_entree,bienFinal,Materiels);
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
