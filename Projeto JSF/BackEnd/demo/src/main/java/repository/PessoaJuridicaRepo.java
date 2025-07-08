package repository;

import entity.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaRepo extends JpaRepository<PessoaJuridica, Integer> {
}
