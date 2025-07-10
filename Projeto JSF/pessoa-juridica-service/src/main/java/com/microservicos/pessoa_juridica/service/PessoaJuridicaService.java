package com.microservicos.pessoa_juridica.service;

import com.microservicos.pessoa_juridica.entity.PessoaJuridica;
import com.microservicos.pessoa_juridica.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public List<PessoaJuridica> listar() {
        return pessoaJuridicaRepository.findAll();
    }

    public PessoaJuridica criar(PessoaJuridica pessoaJuridica) {
        return  pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public PessoaJuridica atualizar(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public Optional<PessoaJuridica> buscarPorId(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }

    public void excluir(Long id) {
        pessoaJuridicaRepository.deleteById(id);
    }
}