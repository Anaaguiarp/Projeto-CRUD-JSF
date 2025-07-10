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

    public PessoaJuridica atualizar(Long id, PessoaJuridica pessoaJuridica) {
        Optional<PessoaJuridica> pessoaJuridicaOptional = pessoaJuridicaRepository.findById(id);
        if (pessoaJuridicaOptional.isPresent()) {
            PessoaJuridica pessoaJuridicaExistente = pessoaJuridicaOptional.get();

            pessoaJuridicaExistente.setNomeFantasia(pessoaJuridica.getNomeFantasia());
            pessoaJuridicaExistente.setRazaoSocial(pessoaJuridica.getRazaoSocial());
            pessoaJuridicaExistente.setEmail(pessoaJuridica.getEmail());
            pessoaJuridicaExistente.setTelefone(pessoaJuridica.getTelefone());
            pessoaJuridicaExistente.setCep(pessoaJuridica.getCep());
            pessoaJuridicaExistente.setLogradouro(pessoaJuridica.getLogradouro());
            pessoaJuridicaExistente.setNumero(pessoaJuridica.getNumero());
            pessoaJuridicaExistente.setComplemento(pessoaJuridica.getComplemento());
            pessoaJuridicaExistente.setBairro(pessoaJuridica.getBairro());
            pessoaJuridicaExistente.setCidade(pessoaJuridica.getCidade());
            pessoaJuridicaExistente.setEstado(pessoaJuridica.getEstado());

            return pessoaJuridicaRepository.save(pessoaJuridicaExistente);

        }
    }

    public Optional<PessoaJuridica> buscarPorId(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }

    public void excluir(Long id) {
        pessoaJuridicaRepository.deleteById(id);
    }
}