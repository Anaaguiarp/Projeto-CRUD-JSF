package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PessoaJuridicaRepo;

@Service
public class PessoaJuridicaService {
    @Autowired
    private PessoaJuridicaRepo pessoaJuridicaRepo;

}
