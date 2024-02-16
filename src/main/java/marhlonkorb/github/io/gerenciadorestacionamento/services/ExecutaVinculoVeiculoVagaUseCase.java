package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.StatusVaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExecutaVinculoVeiculoVagaUseCase {

    @Autowired
    private VagaService vagaService;

    @Autowired
    private VeiculoService veiculoService;

    @Transactional(rollbackFor = Exception.class)
    public void execute(Long idVaga, Long idVeiculo) {
        final Vaga vagaEncontrada = vagaService.getVagaById(idVaga);
        final Veiculo veiculoEncontrado = veiculoService.getVeiculoById(idVeiculo);
        if (vagaEncontrada.getVeiculo() == null && veiculoEncontrado.getVaga() == null) {
            vagaEncontrada.setVeiculo(veiculoEncontrado);
            vagaEncontrada.setStatusVaga(StatusVaga.O);
            veiculoEncontrado.setVaga(vagaEncontrada);
            vagaService.save(vagaEncontrada);
            veiculoService.save(veiculoEncontrado);
        }
    }
}
