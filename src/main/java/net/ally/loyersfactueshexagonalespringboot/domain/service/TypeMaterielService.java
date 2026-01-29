package net.ally.loyersfactueshexagonalespringboot.domain.service;

import net.ally.loyersfactueshexagonalespringboot.domain.model.typemateriel.TypeMateriel;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.TypeMaterielUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.TypeMaterielRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TypeMaterielService implements TypeMaterielUsecase {

    private final TypeMaterielRepositoryPort repositoryPort;

    public TypeMaterielService(TypeMaterielRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public TypeMateriel sauvegarderTypeMateriel(String nom, double prixUnitaire) {
        if(prixUnitaire <= 0) throw new IllegalArgumentException("prix_unitaire must be positive");
        TypeMateriel t = new TypeMateriel(nom, prixUnitaire);
        return repositoryPort.save(t);
    }

    @Override
    public Optional<TypeMateriel> recupererParId(UUID id) {
        return repositoryPort.findById(id);
    }

    @Override
    public void supprimerTypeMateriel(UUID id) {
        repositoryPort.deleteById(id);
    }

    @Override
    public List<TypeMateriel> tousLesTypeMateriels() {
        return repositoryPort.findAll();
    }

    @Override
    public TypeMateriel updateTypeMateriel(UUID id, String nom, double prixUnitaire) {
        TypeMateriel existing = repositoryPort.findById(id).orElseThrow();
        if(prixUnitaire <= 0) throw new IllegalArgumentException("prix_unitaire must be positive");
        existing.setNom(nom);
        existing.setPrixUnitaire(prixUnitaire);
        return repositoryPort.save(existing);
    }
}
