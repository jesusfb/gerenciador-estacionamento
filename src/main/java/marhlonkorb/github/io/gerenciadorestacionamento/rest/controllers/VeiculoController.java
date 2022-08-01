/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
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
        return veiculoService.getListaVeiculos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Veiculo cadastrarVeiculo(@RequestBody @Valid Veiculo veiculo) {
        return veiculoService.cadastrarVeiculo(veiculo);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Veiculo atualizarVeiculo(@PathVariable Integer id, @RequestBody @Valid Veiculo veiculo) {
        veiculoService.alterarVeiculo(id, veiculo);
        return veiculo;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirVeiculo(@PathVariable Integer id) {
        if (veiculoService.excluirVeículo(id)) {
            return ResponseEntity.ok("Registro excluído com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }

}
