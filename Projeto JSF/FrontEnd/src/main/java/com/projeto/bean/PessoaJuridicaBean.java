package com.projeto.bean;

import com.projeto.model.PessoaJuridica;
import com.projeto.service.PessoaJuridicaServiceClient;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaJuridicaBean implements Serializable {

    private List<PessoaJuridica> pessoas;
    private PessoaJuridica pessoaSelecionada;

    @PostConstruct
    public void init() {
        PessoaJuridicaServiceClient client = new PessoaJuridicaServiceClient();
        pessoas = client.listarPessoaJuridica();

        String idParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("id");

        if (idParam != null) {
            System.out.println("ID recebido pela URL: " + idParam);
            try {
                Long id = Long.valueOf(idParam);
                pessoaSelecionada = client.buscarPessoaJuridicaPorId(id);
                System.out.println("Pessoa selecionada: " + pessoaSelecionada.getNome());
            } catch (Exception e) {
                System.out.println("Erro ao buscar pessoa por ID: " + e.getMessage());
            }
        }
    }

    public List<PessoaJuridica> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaJuridica> pessoas) {
        this.pessoas = pessoas;
    }

    public PessoaJuridica getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(PessoaJuridica pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public String buscarPorId(Long id) {
        PessoaJuridicaServiceClient client = new PessoaJuridicaServiceClient();
        try {
            PessoaJuridica pessoa = client.buscarPessoaJuridicaPorId(id);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            Flash flash = facesContext.getExternalContext().getFlash();
            flash.put("pessoaSelecionada", pessoa);

            return "/usuario/visualizarPJ.xhtml?faces-redirect=true&amp;id=" + id;
        } catch (HttpClientErrorException.NotFound e) {
            System.out.println("Pessoa não encontrada com ID: " + id);
            return null;
        }
    }

}