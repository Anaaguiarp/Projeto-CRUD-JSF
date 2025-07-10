package com.microservicos.relatorio.dto;

import java.time.LocalDate;
import java.util.Date;

public record PessoaFisicaDTO(
        String nome,
        String cpf,
        Date dataNasc,
        String genero,
        String estadoCivil,
        String email,
        String telefone,
        LocalDate dataCadastro,
        String cep,
        String cidade,
        String uf,
        String logadouro,
        String numero,
        String bairro,
        String complemento
){}
