package net.ally.loyersfactueshexagonalespringboot.config;

import net.ally.loyersfactueshexagonalespringboot.domain.port.output.BienRepositoryPort;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocataireRepositryPort;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocateurRepositoryPort;
import net.ally.loyersfactueshexagonalespringboot.domain.port.output.TypeMaterielRepositoryPort;
import net.ally.loyersfactueshexagonalespringboot.domain.service.BienService;
import net.ally.loyersfactueshexagonalespringboot.domain.service.LocataireService;
import net.ally.loyersfactueshexagonalespringboot.domain.service.LocateurService;
import net.ally.loyersfactueshexagonalespringboot.domain.service.TypeMaterielService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public LocateurService locateurService(LocateurRepositoryPort locateurRepositoryPort){
        return new LocateurService(locateurRepositoryPort);
    }

    @Bean
    public BienService bienService(BienRepositoryPort bienRepositoryPort){
        return new BienService(bienRepositoryPort);
    }

    @Bean
    public LocataireService locataireService(LocataireRepositryPort locataireRepositryPort, BienRepositoryPort bienRepositoryPort){
        return new LocataireService(locataireRepositryPort, bienRepositoryPort);
    }

    @Bean
    public TypeMaterielService typeMaterielService(TypeMaterielRepositoryPort repositoryPort) {
        return new TypeMaterielService(repositoryPort);
    }
}
