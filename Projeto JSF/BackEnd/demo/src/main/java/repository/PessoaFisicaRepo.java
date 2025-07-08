package repository;

import entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaRepo extends JpaRepository<PessoaFisica, Integer> {
}
