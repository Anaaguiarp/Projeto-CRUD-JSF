package com.projetofinal.demo.controller;

import com.projetofinal.demo.entity.PessoaFisica;
import com.projetofinal.demo.repository.PessoaFisicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projetofinal.demo.service.PessoaFisicaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping("/pessoas")
    public List<PessoaFisica> findAll(){
        return pessoaFisicaService.listar();
    }

    @GetMapping("/pessoa/{id}")
    public Optional<PessoaFisica> findById(@PathVariable Integer id){
        return pessoaFisicaService.buscarPorId(id);
    }

    @PostMapping("/criar")
    public PessoaFisica create(@RequestBody PessoaFisica pessoaFisica){
        return pessoaFisicaService.salvar(pessoaFisica);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Integer id){
        pessoaFisicaService.excluir(id);
    }

}
