package com.microservicos.pessoa_fisica.controller;

import com.microservicos.pessoa_fisica.entity.PessoaFisica;
import com.microservicos.pessoa_fisica.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping("/criar")
    public PessoaFisica create(@RequestBody PessoaFisica pessoaFisica){
        return pessoaFisicaService.salvar(pessoaFisica);
    }

    @GetMapping
    public List<PessoaFisica> findAll(){
        return pessoaFisicaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<PessoaFisica> findById(@PathVariable Long id){
        return pessoaFisicaService.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public PessoaFisica update (@PathVariable Long id, @RequestBody PessoaFisica pessoaFisica){
        return pessoaFisicaService.atualizar(id, pessoaFisica);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Long id){
        pessoaFisicaService.excluir(id);
    }
}
