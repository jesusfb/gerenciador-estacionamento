/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityController;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.Proprietario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável por tratar as requisições Http para a classe Veiculo
 */
@RestController
@RequestMapping("veiculo")
public class VeiculoController extends AbstractEntityController<Veiculo, Long, VeiculoInputMapper, VeiculoOutputMapper> {

    @Autowired
    VeiculoService veiculoService;

    /**
     * Executa a ação de adicionar o id de Proprietario a tabela de Veiculo
     *
     * @param idVeiculo
     * @param idProprietario
     * @return veiculo
     */
    @PostMapping("/addVeiculo{idVeiculo}&{idProprietario}")
    public ResponseEntity<?> adicionarVeiculoCadastrado(@PathVariable Veiculo idVeiculo, @PathVariable Proprietario idProprietario) {
        if (veiculoService.adicionarVeiculoCadastrado(idVeiculo, idProprietario)) {
            return ResponseEntity.ok("Proprietario vinculada a veículo com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Não foi possível realizar o vínculo das entidades.");
        }
    }
}
