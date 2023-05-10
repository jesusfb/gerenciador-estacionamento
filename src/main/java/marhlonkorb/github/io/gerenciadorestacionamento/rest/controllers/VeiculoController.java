/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável por tratar as requisições Http para a classe Veiculo
 */
@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getListaVeiculos() {
        return veiculoService.getVeiculos();
    }

    @GetMapping("{id}")
    public Optional<Veiculo> getById(@PathVariable Long id) {
        return veiculoService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Veiculo cadastrarVeiculo(@RequestBody @Valid Veiculo veiculo) {
        return veiculoService.cadastrarVeiculo(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody @Valid Veiculo veiculo) {
        Optional<Veiculo> veiculoEncontrado = veiculoService.getById(id);
        if (veiculoEncontrado.isPresent()) {
            veiculoService.alterarVeiculo(veiculo);
            return ResponseEntity.ok(veiculo);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirVeiculo(@PathVariable Long id) {
        if (veiculoService.isExists(id)) {
            veiculoService.excluirVeículo(id);
            return ResponseEntity.ok("Registro excluído com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Executa a ação de adicionar o id de Pessoa a tabela de Veiculo
     *
     * @param idVeiculo
     * @param idPessoa
     * @return veiculo
     */
    @PostMapping("/addVeiculo{idVeiculo}&{idPessoa}")
    public ResponseEntity<?> adicionarVeiculoCadastrado(@PathVariable Veiculo idVeiculo, @PathVariable Pessoa idPessoa) {
        if (veiculoService.adicionarVeiculoCadastrado(idVeiculo, idPessoa)) {
            return ResponseEntity.ok("Pessoa vinculada a veículo com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível realizar o vínculo das entidades.");
        }
    }
}
