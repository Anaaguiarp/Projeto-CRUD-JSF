package com.microservicos.pessoa_juridica.controller;

import com.microservicos.pessoa_juridica.entity.PessoaJuridica;
import com.microservicos.pessoa_juridica.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa-juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @PostMapping("/pessoa-juridica")
    public PessoaJuridica create(@RequestBody PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaService.salvar(pessoaJuridica);
    }

    @GetMapping("/")
    public List<PessoaJuridica> findAll() {
        return pessoaJuridicaService.listar();
    }

    @GetMapping("/pessoa-juridica/{id}")
    public Optional<PessoaJuridica> findById(@PathVariable Long id) {
        return pessoaJuridicaService.buscarPorId(id);
    }

    @DeleteMapping("/pessoa-juridica/{id}")
    public void delete(@PathVariable Long id) {
        pessoaJuridicaService.excluir(id);
    }

}