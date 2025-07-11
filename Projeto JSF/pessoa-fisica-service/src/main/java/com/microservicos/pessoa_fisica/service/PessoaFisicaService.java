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

    public PessoaFisica atualizar(Long id, PessoaFisica pessoaFisica) {
        Optional<PessoaFisica> pessoaFisicaOptional = pessoaFisicaRepository.findById(id);
        if (pessoaFisicaOptional.isPresent()) {
            PessoaFisica pessoaFisicaExistente = pessoaFisicaOptional.get();

            pessoaFisicaExistente.setNome(pessoaFisica.getNome());
            pessoaFisicaExistente.setGenero(pessoaFisica.getGenero());
            pessoaFisicaExistente.setEstadoCivil(pessoaFisica.getEstadoCivil());
            pessoaFisicaExistente.setEmail(pessoaFisica.getEmail());
            pessoaFisicaExistente.setTelefone(pessoaFisica.getTelefone());
            pessoaFisicaExistente.setCep(pessoaFisica.getCep());
            pessoaFisicaExistente.setLogadouro(pessoaFisica.getLogadouro());
            pessoaFisicaExistente.setNumero(pessoaFisica.getNumero());
            pessoaFisicaExistente.setComplemento(pessoaFisica.getComplemento());
            pessoaFisicaExistente.setBairro(pessoaFisica.getBairro());
            pessoaFisicaExistente.setCidade(pessoaFisica.getCidade());
            pessoaFisicaExistente.setUf(pessoaFisica.getUf());

            return pessoaFisicaRepository.save(pessoaFisicaExistente);
        }
        return null;
    }
}
