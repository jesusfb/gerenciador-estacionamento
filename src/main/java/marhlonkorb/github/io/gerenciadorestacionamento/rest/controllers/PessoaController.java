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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Pessoa adicionarPessoa(@RequestBody @Valid Pessoa pessoa) {
        pessoaService.adicionarPessoa(pessoa);
        return pessoa;
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterarPessoa(@PathVariable Integer id, @Valid Pessoa pessoa){
        pessoaService.alterarCadastroPessoa(id, pessoa);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> excluirpessoa(@PathVariable Integer id) {
        pessoaService.excluirPessoa(id);
        return ResponseEntity.ok("Registro excluído com sucesso.");
    }

}
