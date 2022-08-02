/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
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

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Pessoa> getPessoaPeloId(@PathVariable Integer id) {
        if (pessoaService.getpessoaPeloId(id) != null) {
            return pessoaService.getpessoaPeloId(id);
        }
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Pessoa> getListaPessoa() {
        return pessoaService.getlistpessoa();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Pessoa cadastrarPessoa(@RequestBody @Valid Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> atualizarCadastro(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        if (pessoaService.alterarCadastroPessoa(id, pessoa) != null) {
            return ResponseEntity.ok("Registro alterado com sucesso.");
        }
        return ResponseEntity.accepted().body("Registro não encontrado.");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> excluirPessoa(@PathVariable Integer id) {
        if (pessoaService.excluirPessoa(id)) {
            return ResponseEntity.ok("Registro excluído com sucesso.");
        }
        return ResponseEntity.accepted().body("Registro não encontrado.");
    }

    /**
     * Executa a ação de salvar o id de Pessoa a tabela de Veiculo
     *
     * @param idVeiculo
     * @param idPessoa
     * @return veiculo
     */
    @PostMapping("/addVeiculo{idVeiculo}&{idPessoa}")
    public Veiculo adicionarVeiculoCadastrado(@PathVariable Veiculo idVeiculo, @PathVariable Pessoa idPessoa) {
        return pessoaService.adicionarVeiculoCadastrado(idVeiculo, idPessoa);
    }

}
