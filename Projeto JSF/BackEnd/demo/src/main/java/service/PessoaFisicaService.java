package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PessoaFisicaRepo;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaRepo pessoaFisicaRepo;

}
