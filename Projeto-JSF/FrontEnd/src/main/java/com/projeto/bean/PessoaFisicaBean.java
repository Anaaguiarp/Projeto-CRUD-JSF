package com.projeto.bean;

import com.projeto.model.PessoaFisica;
import com.projeto.service.PessoaFisicaServiceClient;
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
public class PessoaFisicaBean implements Serializable {

    private List<PessoaFisica> pessoas;
    private PessoaFisica pessoaSelecionada;

    @PostConstruct
    public void init() {
        PessoaFisicaServiceClient client = new PessoaFisicaServiceClient();
        pessoas = client.listarPessoaFisica();

        String idParam = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("id");

        if (idParam != null) {
            System.out.println("ID recebido pela URL: " + idParam);
            try {
                Long id = Long.valueOf(idParam);
                pessoaSelecionada = client.buscarPessoaFisicaPorId(id);
                System.out.println("Pessoa selecionada: " + pessoaSelecionada.getNome());
            } catch (Exception e) {
                System.out.println("Erro ao buscar pessoa por ID: " + e.getMessage());
            }
        }
    }

    public List<PessoaFisica> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaFisica> pessoas) {
        this.pessoas = pessoas;
    }

    public PessoaFisica getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(PessoaFisica pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public String buscarPorId(Long id) {
        PessoaFisicaServiceClient client = new PessoaFisicaServiceClient();
        try {
            PessoaFisica pessoa = client.buscarPessoaFisicaPorId(id);

            FacesContext facesContext = FacesContext.getCurrentInstance();
            Flash flash = facesContext.getExternalContext().getFlash();
            flash.put("pessoaSelecionada", pessoa);

            return "/usuario/visualizarPF.xhtml?faces-redirect=true&amp;id=" + id;
        } catch (HttpClientErrorException.NotFound e) {
            System.out.println("Pessoa não encontrada com ID: " + id);
            return null;
        }
    }

}
