package com.projetofinal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetofinal.demo.service.PessoaFisicaService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

}
