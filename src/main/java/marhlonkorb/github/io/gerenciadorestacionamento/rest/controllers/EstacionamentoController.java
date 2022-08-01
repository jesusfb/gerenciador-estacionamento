/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável por controlar o registro de veiculos no estacionamento
 */
@RestController(value = "/estacionamento")
public class EstacionamentoController {

    /*@Autowired
    private EstacionamentoController estacionamentoController;

    @PostMapping
    public ResponseEntity adicionarVeiculoVaga(@RequestBody Veiculo veiculo) {

    }*/
}
