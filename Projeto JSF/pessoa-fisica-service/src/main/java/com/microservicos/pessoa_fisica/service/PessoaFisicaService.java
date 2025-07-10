package com.microservicos.pessoa_fisica.service;

import com.microservicos.pessoa_fisica.entity.PessoaFisica;
import com.microservicos.pessoa_fisica.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public List<PessoaFisica> listar(){
        return pessoaFisicaRepository.findAll();
    }

    public PessoaFisica salvar(PessoaFisica pessoa){
        return pessoaFisicaRepository.save(pessoa);
    }

    public Optional<PessoaFisica> buscarPorId(Long id){
        return pessoaFisicaRepository.findById(id);
    }

    public void excluir(Long id){
        pessoaFisicaRepository.deleteById(id);
    }
}
