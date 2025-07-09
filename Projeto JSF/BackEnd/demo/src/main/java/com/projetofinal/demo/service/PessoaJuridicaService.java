package com.projetofinal.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetofinal.demo.repository.PessoaJuridicaRepo;

@Service
public class PessoaJuridicaService {
    @Autowired
    private PessoaJuridicaRepo pessoaJuridicaRepo;

}
