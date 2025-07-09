package com.projetofinal.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetofinal.demo.repository.EnderecoRepo;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepo enderecoRepo;

}
