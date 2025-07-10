package com.microservicos.relatorio.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
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

    private final String PF_URL = "http://localhost:8081/pessoa-fisica/";
    private final String PJ_URL = "http://localhost:8082/pessoa-juridica/";

    private List<PessoaFisicaDTO> buscarPFViaREST() {
        return Arrays.asList(restTemplate.getForObject(PF_URL, PessoaFisicaDTO[].class));
    }

    private List<PessoaJuridicaDTO> buscarPJViaREST() {
        return Arrays.asList(restTemplate.getForObject(PJ_URL, PessoaJuridicaDTO[].class));
    }

    private void exportarPessoaFisicaPdf(List<PessoaFisicaDTO> lista, HttpServletResponse response) {
        try{
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=pessoas-fisicas.pdf");

            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            Font tituloNegrito = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16); // Tamanho opcional

            document.add(new Paragraph("Relatório de Pessoas Físicas", tituloNegrito));
            document.add(new Paragraph(" "));

            for (PessoaFisicaDTO pf : lista){
                document.add(new Paragraph("Nome: "+pf.nome()));
                document.add(new Paragraph("CPF: "+pf.cpf()));
                document.add(new Paragraph("Data de Nascimento: "+pf.dataNasc()));
                document.add(new Paragraph("Gênero: "+pf.genero()));
                document.add(new Paragraph("Estado Civil: "+pf.estadoCivil()));
                document.add(new Paragraph("E-mail: " + pf.email()));
                document.add(new Paragraph("Telefone: " + pf.telefone()));
                document.add(new Paragraph("Cidade: " + pf.cidade()));
                document.add(new Paragraph("Estado: " + pf.uf()));
                document.add(new Paragraph(" "));
            }

            document.close();
        }catch(Exception e){
            throw new RuntimeException("Erro ao gerar PDF: " + e.getMessage());
        }
    }

    private void exportarPessoaJuridicaPdf(List<PessoaJuridicaDTO> lista, HttpServletResponse response) {
        try{
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=pessoas-juridicas.pdf");

            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            Font tituloNegrito = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16); // Tamanho opcional

            document.add(new Paragraph("Relatório de Pessoas Jurídica", tituloNegrito));
            document.add(new Paragraph(" "));

            for (PessoaJuridicaDTO pj : lista){
                document.add(new Paragraph("Nome Fantasia: "+pj.nomeFantasia()));
                document.add(new Paragraph("CNPJ: "+pj.cnpj()));
                document.add(new Paragraph("E-mail: " + pj.email()));
                document.add(new Paragraph("Telefone: " + pj.telefone()));
                document.add(new Paragraph("Cidade: " + pj.cidade()));
                document.add(new Paragraph("Estado: " + pj.uf()));
                document.add(new Paragraph(" "));
            }

            document.close();
        }catch(Exception e){
            throw new RuntimeException("Erro ao gerar PDF: " + e.getMessage());
        }
    }

    public void gerarRelatorioPessoas(HttpServletResponse response) {
        List<PessoaFisicaDTO> pessoasFisicas = buscarPFViaREST();
        List<PessoaJuridicaDTO> pessoasJuridicas = buscarPJViaREST();
    }

    public void gerarRelatorioPessoaFisica(HttpServletResponse response) {
        List<PessoaFisicaDTO> dados = buscarPFViaREST();

        exportarPessoaFisicaPdf(dados, response);
    }

    public void gerarRelatorioPessoaJuridica(HttpServletResponse response) {
        List<PessoaJuridicaDTO> dados = buscarPJViaREST();

        exportarPessoaJuridicaPdf(dados, response);
    }

    public void gerarRelatorioEstados(HttpServletResponse response) {

    }

}
