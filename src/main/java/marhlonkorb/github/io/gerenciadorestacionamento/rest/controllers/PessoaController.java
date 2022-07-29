/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import java.util.List;
import javax.validation.Valid;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controla as requisições da entidade Pessoa
 */
@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("{id}")
    public Pessoa getPessoaPeloId(@PathVariable Integer id) {
        return pessoaService.getpessoaPeloId(id);
    }

    @GetMapping
    public List<Pessoa> getListaPessoa() {
        return pessoaService.getlistpessoa();
    }

    @PostMapping
    public @ResponseBody
    Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.adicionarPessoa(pessoa);
        return pessoa;
    }

    @DeleteMapping(path = "/{id}")
    public void excluirpessoa(@PathVariable Integer id) {
        pessoaService.excluirPessoa(id);
    }

}
