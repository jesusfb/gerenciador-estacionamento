package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.StatusVaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdicionaVeiculoVagaUseCase {

    private final VagaService vagaService;
    private final VeiculoService veiculoService;

    public AdicionaVeiculoVagaUseCase(VagaService vagaService, VeiculoService veiculoService) {
        this.vagaService = vagaService;
        this.veiculoService = veiculoService;
    }

    @Transactional
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
