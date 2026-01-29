package net.ally.loyersfactueshexagonalespringboot.config;

import net.ally.loyersfactueshexagonalespringboot.domain.port.input.BienUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocataireUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.port.input.LocateurUsecase;
import net.ally.loyersfactueshexagonalespringboot.domain.service.BienService;
import net.ally.loyersfactueshexagonalespringboot.domain.service.LocataireService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    @Bean
    public LocateurUsecase locateurUsecase(LocateurUsecase locateurUsecase){
        return locateurUsecase;
    }

    @Bean
    public BienUsecase bienUsecase(BienService bienService){return bienService;}

    @Bean
    public LocataireUsecase locataireUsecase(LocataireService locataireService){return locataireService;}
}
