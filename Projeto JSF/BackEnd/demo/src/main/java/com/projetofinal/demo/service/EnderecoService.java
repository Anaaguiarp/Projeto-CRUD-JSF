package com.projetofinal.demo.service;

import com.projetofinal.demo.entity.Endereco;
import com.projetofinal.demo.entity.PessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetofinal.demo.repository.EnderecoRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepo enderecoRepo;

    public List<Endereco> listar(){
        return enderecoRepo.findAll();
    }

    public Endereco salvar(Endereco endereco){
        return enderecoRepo.save(endereco);
    }

    public Optional<Endereco> buscarPorId(int id){
        return enderecoRepo.findById(id);
    }

    public void excluir(int id){
        enderecoRepo.deleteById(id);
    }

}
