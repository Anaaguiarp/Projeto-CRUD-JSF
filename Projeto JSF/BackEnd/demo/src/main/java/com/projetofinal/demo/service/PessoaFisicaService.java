package com.projetofinal.demo.service;

import com.projetofinal.demo.entity.PessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetofinal.demo.repository.PessoaFisicaRepo;

<<<<<<< Updated upstream
import java.util.List;
import java.util.Optional;

=======
>>>>>>> Stashed changes
@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepo pessoaFisicaRepo;

<<<<<<< Updated upstream
    public List<PessoaFisica> listar(){
        return pessoaFisicaRepo.findAll();
    }

    public PessoaFisica salvar(PessoaFisica pessoa){
        return pessoaFisicaRepo.save(pessoa);
    }

    public Optional<PessoaFisica> buscarPorId(int id){
        return pessoaFisicaRepo.findById(id);
    }

    public void excluir(int id){
        pessoaFisicaRepo.deleteById(id);
    }

=======
>>>>>>> Stashed changes
    public PessoaFisica
}
