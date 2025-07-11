package com.microservicos.relatorio.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.microservicos.relatorio.dto.PessoaFisicaDTO;
import com.microservicos.relatorio.dto.PessoaJuridicaDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    private RestTemplate restTemplate;

    private final String PF_URL = "http://localhost:8081/pessoa-fisica/";
    private final String PJ_URL = "http://localhost:8082/pessoa-juridica/";

    private List<PessoaFisicaDTO> buscarPFViaREST() {
        return Optional.ofNullable(restTemplate.getForObject(PF_URL, PessoaFisicaDTO[].class))
                .map(Arrays::asList)
                .orElse(List.of());
    }

    private List<PessoaJuridicaDTO> buscarPJViaREST() {
        return Optional.ofNullable(restTemplate.getForObject(PJ_URL, PessoaJuridicaDTO[].class))
                .map(Arrays::asList)
                .orElse(List.of());
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

            Font tituloNegrito = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);

            document.add(new Paragraph("Relatório de Pessoas Jurídica", tituloNegrito));
            document.add(new Paragraph(" "));

            for (PessoaJuridicaDTO pj : lista){
                document.add(new Paragraph("Nome Fantasia: " + pj.nomeFantasia()));
                document.add(new Paragraph("Razão Social: " + pj.razaoSocial()));
                document.add(new Paragraph("CNPJ: " + pj.cnpj()));
                document.add(new Paragraph("E-mail: " + pj.email()));
                document.add(new Paragraph("Telefone: " + pj.telefone()));
                document.add(new Paragraph("CEP: " + pj.cep()));
                document.add(new Paragraph("Cidade: " + pj.cidade() + " - " + pj.estado()));
                document.add(new Paragraph("Bairro: " + pj.bairro()));
                document.add(new Paragraph("Logradouro: " + pj.logradouro()));
                document.add(new Paragraph("Número: " + pj.numero()));
                document.add(new Paragraph(" "));
            }

            document.close();
        }catch(Exception e){
            throw new RuntimeException("Erro ao gerar PDF: " + e.getMessage());
        }
    }

    private void exportarPessoasPdf(List<PessoaFisicaDTO> pessoasFisicas, List<PessoaJuridicaDTO> pessoasJuridicas, HttpServletResponse response) {
        try{
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=pessoas.pdf");

            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();

            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font subtitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13);

            document.add(new Paragraph("Relatório de Pessoas Físicas e Jurídicas", titulo));

            document.add(new Paragraph("Relatório de Pessoas Físicas", subtitulo));
            document.add(new Paragraph(" "));

            for (PessoaFisicaDTO pf : pessoasFisicas){
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

            document.add(new Paragraph("Relatório de Pessoas Jurídica", subtitulo));
            document.add(new Paragraph(" "));

            for (PessoaJuridicaDTO pj : pessoasJuridicas){
                document.add(new Paragraph("Nome Fantasia: " + pj.nomeFantasia()));
                document.add(new Paragraph("Razão Social: " + pj.razaoSocial()));
                document.add(new Paragraph("CNPJ: " + pj.cnpj()));
                document.add(new Paragraph("E-mail: " + pj.email()));
                document.add(new Paragraph("Telefone: " + pj.telefone()));
                document.add(new Paragraph("CEP: " + pj.cep()));
                document.add(new Paragraph("Cidade: " + pj.cidade() + " - " + pj.estado()));
                document.add(new Paragraph("Bairro: " + pj.bairro()));
                document.add(new Paragraph("Logadouro: " + pj.logradouro()));
                document.add(new Paragraph("Número: " + pj.numero()));
                document.add(new Paragraph(" "));
            }

            document.close();

        }catch(Exception e){
            throw new RuntimeException("Erro ao gerar PDF: " + e.getMessage());
        }
    }

    private void exportarPessoasEstadosPdf(Map<String, List<PessoaFisicaDTO>> pfPorUf, Map<String, List<PessoaJuridicaDTO>> pjPorUf, HttpServletResponse response){
        try {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=pessoas-por-uf.pdf");

            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            Font titulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font subtitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13);

            document.add(new Paragraph("Relatório de Pessoas Físicas e Jurídicas por UF", titulo));
            document.add(new Paragraph(" "));

            Set<String> ufs = new TreeSet<>();
            ufs.addAll(pfPorUf.keySet());
            ufs.addAll(pjPorUf.keySet());

            for (String uf : ufs) {
                document.add(new Paragraph("UF: " + uf, subtitulo));
                document.add(new Paragraph(" "));

                List<PessoaFisicaDTO> pfs = pfPorUf.getOrDefault(uf, List.of());
                if (!pfs.isEmpty()) {
                    document.add(new Paragraph("Pessoas Físicas:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                    for (PessoaFisicaDTO pf : pfs) {
                        document.add(new Paragraph("Nome: " + pf.nome()));
                        document.add(new Paragraph("CPF: " + pf.cpf()));
                        document.add(new Paragraph("Email: " + pf.email()));
                        document.add(new Paragraph("Cidade: " + pf.cidade()));
                        document.add(new Paragraph(" "));
                    }
                }

                List<PessoaJuridicaDTO> pjs = pjPorUf.getOrDefault(uf, List.of());
                if (!pjs.isEmpty()) {
                    document.add(new Paragraph("Pessoas Jurídicas:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                    for (PessoaJuridicaDTO pj : pjs) {
                        document.add(new Paragraph("Nome Fantasia: " + pj.nomeFantasia()));
                        document.add(new Paragraph("CNPJ: " + pj.cnpj()));
                        document.add(new Paragraph("Email: " + pj.email()));
                        document.add(new Paragraph("Cidade: " + pj.cidade()));
                        document.add(new Paragraph(" "));
                    }
                }

                document.add(new Paragraph("--------------------------------------------------"));
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
        exportarPessoasPdf(pessoasFisicas, pessoasJuridicas, response);
    }

    public void gerarRelatorioPessoaFisica(HttpServletResponse response) {
        List<PessoaFisicaDTO> pessoasFisicas = buscarPFViaREST();
        exportarPessoaFisicaPdf(pessoasFisicas, response);
    }

    public void gerarRelatorioPessoaJuridica(HttpServletResponse response) {
        List<PessoaJuridicaDTO> pessoasJuridicas = buscarPJViaREST();
        exportarPessoaJuridicaPdf(pessoasJuridicas, response);
    }

    public void gerarRelatorioPessoasEstados(HttpServletResponse response){
        List<PessoaFisicaDTO> pessoasFisicas = buscarPFViaREST();
        List<PessoaJuridicaDTO> pessoasJuridicas = buscarPJViaREST();

        Map<String, List<PessoaFisicaDTO>> pfPorUf = pessoasFisicas.stream()
                .filter(p -> p.uf() != null)
                .collect(Collectors.groupingBy(PessoaFisicaDTO::uf));

        Map<String, List<PessoaJuridicaDTO>> pjPorUf = pessoasJuridicas.stream()
                .filter(p -> p.estado() != null)
                .collect(Collectors.groupingBy(PessoaJuridicaDTO::estado));

        exportarPessoasEstadosPdf(pfPorUf, pjPorUf, response);
    }





}
