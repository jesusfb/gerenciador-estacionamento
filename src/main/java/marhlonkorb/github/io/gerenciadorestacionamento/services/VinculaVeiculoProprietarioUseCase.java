package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.Proprietario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import org.springframework.stereotype.Service;

@Service
public class VinculaVeiculoProprietarioUseCase {

    private final VeiculoService veiculoService;
    private final ProprietarioService proprietarioService;

    public VinculaVeiculoProprietarioUseCase(VeiculoService veiculoService, ProprietarioService proprietarioService) {
        this.veiculoService = veiculoService;
        this.proprietarioService = proprietarioService;
    }

    /**
     * Executa o vínculo entre o veículo e o proprietário
     *
     * @param idVeiculo
     * @param idProprietario
     */
    public void execute(Long idVeiculo, Long idProprietario) {
        final Veiculo veiculo = veiculoService.getVeiculoById(idVeiculo);
        final Proprietario proprietario = proprietarioService.getProprietarioById(idProprietario);
        veiculo.setProprietario(proprietario);
        proprietario.setId(proprietario.getId());
        proprietarioService.save(proprietario);
        veiculoService.save(veiculo);
    }

}
