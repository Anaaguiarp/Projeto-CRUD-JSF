package com.projeto.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.projeto.model.PessoaDTO;
import com.projeto.model.PessoaFisica;
import com.projeto.model.PessoaJuridica;
import jakarta.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "consultaPessoaBean")
@ViewScoped
public class ConsultaPessoaBean implements Serializable {
    private List<PessoaDTO> pessoas;

    @PostConstruct
    public void init() {
        pessoas = new ArrayList<>();
        pessoas.addAll(mapearFisicas(buscarPessoasFisicas()));
        pessoas.addAll(mapearJuridicas(buscarPessoasJuridicas()));
    }

    private List<PessoaFisica> buscarPessoasFisicas() {
        List<PessoaFisica> lista = new ArrayList<>();
        try {
            URL url = new URL("http://pessoa-fisica:8080/pessoa-fisica");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            lista = new Gson().fromJson(reader, new TypeToken<List<PessoaFisica>>(){}.getType());

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    private List<PessoaJuridica> buscarPessoasJuridicas() {
        List<PessoaJuridica> lista = new ArrayList<>();
        try {
            URL url = new URL("http://pessoa-juridica:8080/pessoa-juridica");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            lista = new Gson().fromJson(reader, new TypeToken<List<PessoaJuridica>>(){}.getType());

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    private List<PessoaDTO> mapearFisicas(List<PessoaFisica> fisicas) {
        List<PessoaDTO> lista = new ArrayList<>();
        for (PessoaFisica pf : fisicas) {
            PessoaDTO dto = new PessoaDTO();
            dto.setNome(pf.getNome());
            dto.setIdentificador(pf.getCpf());
            dto.setEmail(pf.getEmail());
            dto.setDataCadastro(pf.getDataCadastro());
            dto.setTipo("Física");
            lista.add(dto);
        }
        return lista;
    }

    private List<PessoaDTO> mapearJuridicas(List<PessoaJuridica> juridicas) {
        List<PessoaDTO> lista = new ArrayList<>();
        for (PessoaJuridica pj : juridicas) {
            PessoaDTO dto = new PessoaDTO();
            dto.setNome(pj.getNomeFantasia());
            dto.setIdentificador(pj.getCnpj());
            dto.setEmail(pj.getEmail());
            dto.setDataCadastro(pj.getDataCadastro());
            dto.setTipo("Jurídica");
            lista.add(dto);
        }
        return lista;
    }

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }
}
