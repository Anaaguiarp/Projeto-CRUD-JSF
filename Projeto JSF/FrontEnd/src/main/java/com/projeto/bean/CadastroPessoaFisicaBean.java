package com.projeto.bean;

import com.projeto.model.PessoaFisica;
import com.projeto.service.PessoaFisicaServiceClient;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class CadastroPessoaFisicaBean implements Serializable {

    private PessoaFisica pessoaFisica = new PessoaFisica();

    public String cadastrar() {
        PessoaFisicaServiceClient client = new PessoaFisicaServiceClient();
        client.salvarPessoaFisica(pessoaFisica);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cadastro realizado com sucesso!"));

        pessoaFisica = new PessoaFisica();

        return "consulta.xhtml?faces-redirect=true";
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
}
