package com.microservicos.relatorio.dto;

import java.time.LocalDate;

public record EnderecoDTO(
        String cep,
        String cidade,
        String uf,
        String logradouro,
        int numero,
        String bairro,
        String complemento,
        LocalDate dataCadastro
) {}