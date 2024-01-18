/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityController;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.services.VeiculoService;
import marhlonkorb.github.io.gerenciadorestacionamento.services.VinculaVeiculoProprietarioUseCase;
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

    private final VinculaVeiculoProprietarioUseCase vinculaVeiculoProprietarioUseCase;

    public VeiculoController(VinculaVeiculoProprietarioUseCase vinculaVeiculoProprietarioUseCase) {
        this.vinculaVeiculoProprietarioUseCase = vinculaVeiculoProprietarioUseCase;
    }

    /**
     * Executa o vínculo do veículo ao proprietário
     *
     * @param idVeiculo
     * @param idProprietario
     * @return veiculo
     */
    @PostMapping("/vincula{idVeiculo}&{idProprietario}")
    public ResponseEntity<?> vinculaVeiculoProprietario(@PathVariable Long idVeiculo, @PathVariable Long idProprietario) {
        try {
            vinculaVeiculoProprietarioUseCase.execute(idVeiculo, idProprietario);
            return ResponseEntity.ok("Veículo vinculado ao Proprietario com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível vincular o veículo ao proprietario.");
        }
    }
}
