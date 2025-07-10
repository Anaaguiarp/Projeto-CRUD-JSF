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

    @PostMapping("/criar")
    public PessoaJuridica create(@RequestBody PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaService.criar(pessoaJuridica);
    }

    @PutMapping("/atualizar/{id}")
    public PessoaJuridica update (@PathVariable Long id, @RequestBody PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaService.atualizar(id, pessoaJuridica);
    }

    @GetMapping("/")
    public List<PessoaJuridica> findAll() {
        return pessoaJuridicaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<PessoaJuridica> findById(@PathVariable Long id) {
        return pessoaJuridicaService.buscarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Long id) {
        pessoaJuridicaService.excluir(id);
    }

}