/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import java.util.List;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável por controlar o registro de veiculos no estacionamento
 */
@RestController
@RequestMapping("vaga")
public class VagaController extends EntityController<Vaga, Integer>{

    @Autowired
    private VagaService vagaService;

    @PostMapping("/addVeiculoVaga{veiculo}")
    public Vaga adicionarVeiculoVaga(@PathVariable Veiculo veiculo, Vaga vaga) {
        return vagaService.adicionarVeiculoVaga(veiculo, vaga);
    }

}
