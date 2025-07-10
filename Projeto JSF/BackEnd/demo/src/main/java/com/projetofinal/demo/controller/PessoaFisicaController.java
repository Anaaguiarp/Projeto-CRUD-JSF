package com.projetofinal.demo.controller;

<<<<<<< Updated upstream
import com.projetofinal.demo.entity.PessoaFisica;
import com.projetofinal.demo.repository.PessoaFisicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.projetofinal.demo.service.PessoaFisicaService;

<<<<<<< Updated upstream
import java.util.List;
import java.util.Optional;

=======
>>>>>>> Stashed changes
@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

<<<<<<< Updated upstream
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

=======
>>>>>>> Stashed changes
}
