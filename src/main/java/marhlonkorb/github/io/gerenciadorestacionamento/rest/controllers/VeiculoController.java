/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import java.util.List;
import javax.validation.Valid;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public @ResponseBody
    Veiculo cadastrarVeiculo(@RequestBody @Valid Veiculo veiculo) {
        return veiculoService.cadastrarVeiculo(veiculo);
    }

}
