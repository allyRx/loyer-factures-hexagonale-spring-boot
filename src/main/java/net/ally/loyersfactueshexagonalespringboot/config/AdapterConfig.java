package net.ally.loyersfactueshexagonalespringboot.config;

import net.ally.loyersfactueshexagonalespringboot.domain.port.input.BienUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocateurUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    @Bean
    public LocateurUsecase locateurUsecase(LocateurUsecase locateurUsecase){
        return locateurUsecase;
    }

    @Bean
    public BienUsecase bienUsecase(BienUsecase bienUsecase){return bienUsecase;}
}
