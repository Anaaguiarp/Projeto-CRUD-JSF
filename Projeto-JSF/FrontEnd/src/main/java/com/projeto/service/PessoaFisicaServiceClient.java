package com.projeto.service;

import com.projeto.model.PessoaFisica;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

public class PessoaFisicaServiceClient {
    private static final String BASE_URL = "http://localhost:8081";


    public void salvarPessoaFisica(PessoaFisica pessoaFisica) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-fisica/salvar";
        restTemplate.postForObject(BASE_URL + endpoint, pessoaFisica, Void.class);
    }

    public List<PessoaFisica> listarPessoaFisica() {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-fisica/buscar";

        String json = restTemplate.getForObject(BASE_URL + "/pessoa-fisica/buscar", String.class);
        System.out.println("JSON recebido: " + json);

        ResponseEntity<List<PessoaFisica>> response = restTemplate.exchange(
                BASE_URL + endpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PessoaFisica>>() {}
        );

        return response.getBody();
    }

    public PessoaFisica buscarPessoaFisicaPorId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-fisica/buscar/" + id;
        return restTemplate.getForObject(BASE_URL + endpoint, PessoaFisica.class);
    }

    public void deletarPessoaFisica(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-fisica/" + id;
        restTemplate.delete(BASE_URL + endpoint);
    }
}
