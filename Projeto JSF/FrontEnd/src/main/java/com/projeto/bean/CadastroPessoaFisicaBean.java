package com.projeto.bean;

import com.google.gson.Gson;
import com.projeto.model.PessoaFisica;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

@Named("cadastroPessoaFisicaBean")
@ViewScoped
public class CadastroPessoaFisicaBean implements Serializable {

    private PessoaFisica pessoaFisica = new PessoaFisica();

    public String cadastrar() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(pessoaFisica);

            URL url = new URL("http://pessoa-fisica:8080/pessoa-fisica/criar");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
                os.flush();
            }

            if (conn.getResponseCode() != 200 && conn.getResponseCode() != 201) {
                throw new RuntimeException("Erro ao cadastrar PF: HTTP " + conn.getResponseCode());
            }

            conn.disconnect();

            return "consulta.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }
}
