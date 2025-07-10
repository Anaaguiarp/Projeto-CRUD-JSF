package com.projetofinal.demo.service;

<<<<<<< Updated upstream
import com.projetofinal.demo.entity.Endereco;
import com.projetofinal.demo.entity.PessoaFisica;
=======
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetofinal.demo.repository.EnderecoRepo;

<<<<<<< Updated upstream
import java.util.List;
import java.util.Optional;

=======
>>>>>>> Stashed changes
@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepo enderecoRepo;

<<<<<<< Updated upstream
    public List<Endereco> listar(){
        return enderecoRepo.findAll();
    }

    public Endereco salvar(Endereco endereco){
        return enderecoRepo.save(endereco);
    }

    public Optional<Endereco> buscarPorId(int id){
        return enderecoRepo.findById(id);
    }

    public void excluir(int id){
        enderecoRepo.deleteById(id);
    }

=======
>>>>>>> Stashed changes
}
