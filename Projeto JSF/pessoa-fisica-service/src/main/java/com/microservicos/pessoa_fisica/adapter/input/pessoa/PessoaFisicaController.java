package com.microservicos.pessoa_fisica.adapter.input.pessoa;

import com.microservicos.pessoa_fisica.domain.entity.PessoaFisica;
import com.microservicos.pessoa_fisica.domain.usecase.PessoaFisicaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

    private final PessoaFisicaUseCase useCase;

    public PessoaFisicaController(PessoaFisicaUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/salvar")
    public ResponseEntity<PessoaFisica> create(@Validated @RequestBody PessoaFisica pf) {

        return ResponseEntity.ok(useCase.create(pf));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PessoaFisica>> getAll() {
        return ResponseEntity.ok(useCase.getAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PessoaFisica> getById(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.getById(id));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<PessoaFisica> update(@PathVariable Long id,
                                       @Validated @RequestBody PessoaFisica pf) {
        return ResponseEntity.ok(useCase.update(id, pf));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        useCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
