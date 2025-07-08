package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

}
