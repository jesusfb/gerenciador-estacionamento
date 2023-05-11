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
@RequestMapping("veiculo")
public class VeiculoController extends EntityController<Veiculo, Long>{

    @Autowired
    VeiculoService veiculoService;

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
