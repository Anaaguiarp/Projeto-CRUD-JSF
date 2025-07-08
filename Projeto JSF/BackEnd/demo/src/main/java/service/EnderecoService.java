package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EnderecoRepo;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepo enderecoRepo;

}
