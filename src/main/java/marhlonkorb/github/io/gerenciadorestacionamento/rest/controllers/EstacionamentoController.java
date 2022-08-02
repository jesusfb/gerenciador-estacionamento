/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Estacionamento;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.services.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável por controlar o registro de veiculos no estacionamento
 */
@RestController
@RequestMapping("/api/estacionamento")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @PostMapping("/addVeiculoVaga{veiculo}&{estacionamento}")
    public Estacionamento adicionarVeiculoVaga(@PathVariable Veiculo veiculo,
            @PathVariable Estacionamento estacionamento) {
        return estacionamentoService.adicionarVeiculoVaga(veiculo, estacionamento);
    }

}
