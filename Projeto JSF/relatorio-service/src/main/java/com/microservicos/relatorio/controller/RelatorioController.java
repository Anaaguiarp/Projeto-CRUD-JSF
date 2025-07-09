package com.microservicos.relatorio.controller;

import com.microservicos.relatorio.service.RelatorioService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {
    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/pessoas")
    public void gerarRelatorioPessoas(HttpServletResponse response) {
        relatorioService.gerarRelatorioPessoas(response);
    }

    @GetMapping("/pessoa-fisica")
    public void gerarRelatorioPessoaFisica(HttpServletResponse response) {
        relatorioService.gerarRelatorioPessoaFisica(response);
    }

    @GetMapping("/pessoa-juridica")
    public void gerarRelatorioPessoaJuridica(HttpServletResponse response) {
        relatorioService.gerarRelatorioPessoaJuridica(response);
    }

    @GetMapping("/estados")
    public void gerarRelatorioEstados(HttpServletResponse response) {
        relatorioService.gerarRelatorioEstados(response);
    }

}
