package com.microservicos.pessoa_fisica.config;

import com.microservicos.pessoa_fisica.domain.service.PessoaFisicaService;
import com.microservicos.pessoa_fisica.port.output.PessoaFisicaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public PessoaFisicaService pessoaFisicaService(PessoaFisicaRepositoryPort repo) {
        return new PessoaFisicaService(repo);
    }
}
