package com.projeto.service;

import com.projeto.model.PessoaJuridica;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

public class PessoaJuridicaServiceClient {
    private static final String BASE_URL = "http://localhost:8082";


    public void salvarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-juridica/criar";
        restTemplate.postForObject(BASE_URL + endpoint, pessoaJuridica, Void.class);
    }

    public List<PessoaJuridica> listarPessoaJuridica() {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-juridica/buscar";

        String json = restTemplate.getForObject(BASE_URL + "/pessoa-juridica/buscar", String.class);
        System.out.println("JSON recebido: " + json);

        ResponseEntity<List<PessoaJuridica>> response = restTemplate.exchange(
                BASE_URL + endpoint,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PessoaJuridica>>() {}
        );

        return response.getBody();
    }

    public PessoaJuridica buscarPessoaJuridicaPorId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-juridica/buscar/" + id;
        return restTemplate.getForObject(BASE_URL + endpoint, PessoaJuridica.class);
    }

    public void deletarPessoaJuridica(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "/pessoa-juridica/" + id;
        restTemplate.delete(BASE_URL + endpoint);
    }
}