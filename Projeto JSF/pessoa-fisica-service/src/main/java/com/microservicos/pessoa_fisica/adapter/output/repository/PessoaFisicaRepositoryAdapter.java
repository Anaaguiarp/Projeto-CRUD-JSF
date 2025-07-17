package com.microservicos.pessoa_fisica.adapter.output.repository;

import com.microservicos.pessoa_fisica.adapter.output.entity.PessoaFisicaEntity;
import com.microservicos.pessoa_fisica.domain.entity.PessoaFisica;
import com.microservicos.pessoa_fisica.port.output.PessoaFisicaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PessoaFisicaRepositoryAdapter implements PessoaFisicaRepositoryPort {

    private final PessoaFisicaJpaRepository jpa;

    public PessoaFisicaRepositoryAdapter(PessoaFisicaJpaRepository jpa) {
        this.jpa = jpa;
    }

    private PessoaFisica toDomain(PessoaFisicaEntity pf) {
        return new PessoaFisica(pf.getId(),
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
                pf.getComplemento());
    }


    private PessoaFisicaEntity toEntity(PessoaFisica pessoaFisica) {
        var e = new PessoaFisicaEntity();

        e.setId(pessoaFisica.getId());
        e.setNome(pessoaFisica.getNome());
        e.setCpf(pessoaFisica.getCpf());
        e.setDataNasc(pessoaFisica.getDataNasc());
        e.setGenero(pessoaFisica.getGenero());
        e.setEstadoCivil(pessoaFisica.getEstadoCivil());
        e.setEmail(pessoaFisica.getEmail());
        e.setTelefone(pessoaFisica.getTelefone());
        e.setCep(pessoaFisica.getCep());
        e.setCidade(pessoaFisica.getCidade());
        e.setEstado(pessoaFisica.getEstado());
        e.setLogradouro(pessoaFisica.getLogradouro());
        e.setNumero(pessoaFisica.getNumero());
        e.setBairro(pessoaFisica.getBairro());
        e.setComplemento(pessoaFisica.getComplemento());
        return e;
    }

    @Override
    public PessoaFisica save(PessoaFisica pessoaFisica) {
        PessoaFisicaEntity e;

        if (pessoaFisica.getId() != null && jpa.existsById(pessoaFisica.getId())) {
            e = jpa.findById(pessoaFisica.getId())
                    .orElseThrow();
            e.setNome(pessoaFisica.getNome());
            e.setCpf(pessoaFisica.getCpf());
            e.setDataNasc(pessoaFisica.getDataNasc());
            e.setGenero(pessoaFisica.getGenero());
            e.setEstadoCivil(pessoaFisica.getEstadoCivil());
            e.setEmail(pessoaFisica.getEmail());
            e.setTelefone(pessoaFisica.getTelefone());
            e.setCep(pessoaFisica.getCep());
            e.setCidade(pessoaFisica.getCidade());
            e.setEstado(pessoaFisica.getEstado());
            e.setLogradouro(pessoaFisica.getLogradouro());
            e.setNumero(pessoaFisica.getNumero());
            e.setBairro(pessoaFisica.getBairro());
            e.setComplemento(pessoaFisica.getComplemento());
        } else {
            e = new PessoaFisicaEntity();
            e.setNome(pessoaFisica.getNome());
            e.setCpf(pessoaFisica.getCpf());
            e.setDataNasc(pessoaFisica.getDataNasc());
            e.setGenero(pessoaFisica.getGenero());
            e.setEstadoCivil(pessoaFisica.getEstadoCivil());
            e.setEmail(pessoaFisica.getEmail());
            e.setTelefone(pessoaFisica.getTelefone());
            e.setCep(pessoaFisica.getCep());
            e.setCidade(pessoaFisica.getCidade());
            e.setEstado(pessoaFisica.getEstado());
            e.setLogradouro(pessoaFisica.getLogradouro());
            e.setNumero(pessoaFisica.getNumero());
            e.setBairro(pessoaFisica.getBairro());
            e.setComplemento(pessoaFisica.getComplemento());
        }

        PessoaFisicaEntity saved = jpa.save(e);
        return toDomain(saved);
    }

    @Override
    public Optional<PessoaFisica> findById(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }
    @Override
    public List<PessoaFisica> findAll() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
