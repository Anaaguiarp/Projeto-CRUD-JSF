package com.projetofinal.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetofinal.demo.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pessoa-juridica")
public class PessoaJuridicaController {
    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

}
