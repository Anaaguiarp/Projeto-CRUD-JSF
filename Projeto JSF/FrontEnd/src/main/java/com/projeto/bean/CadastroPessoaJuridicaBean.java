package com.projeto.bean;

import com.google.gson.Gson;
import com.projeto.model.PessoaJuridica;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;



import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

@Named("cadastroPessoaJuridicaBean")
@ViewScoped
public class CadastroPessoaJuridicaBean implements Serializable {

    private PessoaJuridica pessoaJuridica = new PessoaJuridica();

    public String cadastrar() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(pessoaJuridica);

            URL url = new URL("http://pessoa-juridica:8080/pessoa-juridica/criar");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
                os.flush();
            }

            if (conn.getResponseCode() != 200 && conn.getResponseCode() != 201) {
                throw new RuntimeException("Erro ao cadastrar PJ: HTTP " + conn.getResponseCode());
            }

            conn.disconnect();

            return "consulta.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }
}
