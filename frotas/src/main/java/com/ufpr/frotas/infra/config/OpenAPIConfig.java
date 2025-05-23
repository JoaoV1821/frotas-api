package com.ufpr.frotas.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI apiDoc() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Frotas")
                        .description("Documentação da API para gestão de veículos e agendamentos")
                        .version("1.0"));
    }
}
