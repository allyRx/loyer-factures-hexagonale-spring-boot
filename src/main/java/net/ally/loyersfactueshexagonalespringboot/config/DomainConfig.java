package net.ally.loyersfactueshexagonalespringboot.config;

import net.ally.loyersfactueshexagonalespringboot.domain.port.output.LocateurRepositoryPort;
import net.ally.loyersfactueshexagonalespringboot.domain.service.LocateurService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public LocateurService locateurService(LocateurRepositoryPort locateurRepositoryPort){
        return new LocateurService(locateurRepositoryPort);
    }
}
