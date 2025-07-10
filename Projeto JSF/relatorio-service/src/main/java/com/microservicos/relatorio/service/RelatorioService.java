package com.microservicos.relatorio.service;

import com.microservicos.relatorio.dto.PessoaFisicaDTO;
import com.microservicos.relatorio.dto.PessoaJuridicaDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private RestTemplate restTemplate;

    private final String PF_URL = "http://localhost:8081/pessoa-fisica/listar";
    private final String PJ_URL = "http://localhost:8082/pessoa-juridica/listar";

    private List<PessoaFisicaDTO> buscarPFViaREST() {
        return Arrays.asList(restTemplate.getForObject(PF_URL, PessoaFisicaDTO[].class));
    }

    private List<PessoaJuridicaDTO> buscarPJViaREST() {
        return Arrays.asList(restTemplate.getForObject(PJ_URL, PessoaJuridicaDTO[].class));
    }

    public void gerarRelatorioPessoas(HttpServletResponse response) {
        List<PessoaFisicaDTO> pessoasFisicas = buscarPFViaREST();
        List<PessoaJuridicaDTO> pessoasJuridicas = buscarPJViaREST();

        System.out.println("Pessoa Física:");
        pessoasFisicas.forEach(pf -> System.out.println(pf.nome() + " - " + pf.cpf()));

        System.out.println("Pessoa Jurídica:");
        pessoasJuridicas.forEach(pj -> System.out.println(pj.nomeFantasia() + " - " + pj.cnpj()));
    }

    public void gerarRelatorioPessoaFisica(HttpServletResponse response) {
        List<PessoaFisicaDTO> dados = buscarPFViaREST();

        System.out.println("Pessoa Física:");
        dados.forEach(pf -> System.out.println(pf.nome() + " - " + pf.cpf()));
    }

    public void gerarRelatorioPessoaJuridica(HttpServletResponse response) {
        List<PessoaJuridicaDTO> dados = buscarPJViaREST();

        System.out.println("Pessoa Física:");
        dados.forEach(pj -> System.out.println(pj.nomeFantasia() + " - " + pj.cnpj()));
    }

    public void gerarRelatorioEstados(HttpServletResponse response) {

    }

}
