package com.microservicos.pessoa_fisica.domain.service;

import com.microservicos.pessoa_fisica.domain.entity.PessoaFisica;
import com.microservicos.pessoa_fisica.domain.execption.PessoaFisicaNotFoundException;
import com.microservicos.pessoa_fisica.domain.usecase.PessoaFisicaUseCase;
import com.microservicos.pessoa_fisica.port.output.PessoaFisicaRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PessoaFisicaService implements PessoaFisicaUseCase {

    private final PessoaFisicaRepositoryPort repo;

    public PessoaFisicaService(PessoaFisicaRepositoryPort repo) {
        this.repo = repo;
    }

    @Override
    public PessoaFisica create(PessoaFisica pf) {
        var now = LocalDateTime.now();
        PessoaFisica toSave = new PessoaFisica(pf.getId(),
                pf.getNome(),
                pf.getCpf(),
                pf.getDataNasc(),
                pf.getGenero(),
                pf.getEstadoCivil(),
                pf.getEmail(),
                pf.getTelefone(),
                pf.getDataCadastro(),
                pf.getCep(),
                pf.getCidade(),
                pf.getEstado(),
                pf.getLogradouro(),
                pf.getNumero(),
                pf.getBairro(),
                pf.getComplemento()
        );
        return repo.save(toSave);
    }

    @Override
    public PessoaFisica getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new PessoaFisicaNotFoundException("Pessoa não encontrada"));
    }

    @Override
    public List<PessoaFisica> getAll() {
        return repo.findAll();
    }

    @Override
    public PessoaFisica update(Long id, PessoaFisica pessoaFisica) {
        PessoaFisica toUpdate = getById(id);

        toUpdate.setNome(pessoaFisica.getNome());
        toUpdate.setCpf(pessoaFisica.getCpf());
        toUpdate.setDataNasc(pessoaFisica.getDataNasc());
        toUpdate.setGenero(pessoaFisica.getGenero());
        toUpdate.setEstadoCivil(pessoaFisica.getEstadoCivil());
        toUpdate.setEmail(pessoaFisica.getEmail());
        toUpdate.setTelefone(pessoaFisica.getTelefone());
        toUpdate.setCep(pessoaFisica.getCep());
        toUpdate.setCidade(pessoaFisica.getCidade());
        toUpdate.setEstado(pessoaFisica.getEstado());
        toUpdate.setLogradouro(pessoaFisica.getLogradouro());
        toUpdate.setNumero(pessoaFisica.getNumero());
        toUpdate.setBairro(pessoaFisica.getBairro());
        toUpdate.setComplemento(pessoaFisica.getComplemento());

        return repo.save(toUpdate);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repo.deleteById(id);
    }
}
