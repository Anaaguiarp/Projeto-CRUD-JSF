package com.projeto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<PessoaDTO> listarTodasPessoas() {
        List<PessoaDTO> resultado = new ArrayList<>();
        resultado.addAll(listarPessoaFisica());
        resultado.addAll(listarPessoaJuridica());
        return resultado;
    }

    private List<PessoaDTO> listarPessoaFisica() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8081/pessoa-fisica"))
                    .GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("JSON PF: " + response.body());
            return mapper.readValue(response.body(), new TypeReference<List<PessoaDTO>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar PF", e);
        }
    }

    private List<PessoaDTO> listarPessoaJuridica() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8082/pessoa-juridica"))
                    .GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("JSON PJ: " + response.body());  // VERIFICA RETORNO
            return mapper.readValue(response.body(), new TypeReference<List<PessoaDTO>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar PJ", e);
        }
    }
}
