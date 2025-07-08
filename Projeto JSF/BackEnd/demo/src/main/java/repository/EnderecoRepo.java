package repository;

import entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepo extends JpaRepository<Endereco, Integer> {
}
