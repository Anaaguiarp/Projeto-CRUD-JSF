package com.microservicos.relatorio.dto;

import java.time.LocalDate;

public record PessoaJuridicaDTO(
        String nomeFantasia,
        String razaoSocial,
        String cnpj,
        String email,
        String telefone,
        LocalDate dataCadastro,
        String cep,
        String cidade,
        String estado,
        String logradouro,
        String numero,
        String bairro,
        String complemento
) {}
