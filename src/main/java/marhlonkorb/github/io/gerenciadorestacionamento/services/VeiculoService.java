/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.Proprietario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.exceptions.ProprietarioNotFoundException;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.exceptions.VeiculoNotFoundException;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.ProprietarioRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Veiculo
 */
@Service
public class VeiculoService extends AbstractEntityService<Veiculo, Long, VeiculoInputMapper, VeiculoOutputMapper> {

    private final VeiculoRepository veiculoRepository;

    private final ProprietarioService proprietarioService;

    private final VeiculoMapper veiculoMapper;

    public VeiculoService(VeiculoRepository veiculoRepository, ProprietarioService proprietarioService, VeiculoMapper veiculoMapper) {
        this.veiculoRepository = veiculoRepository;
        this.proprietarioService = proprietarioService;
        this.veiculoMapper = veiculoMapper;
    }

    /**
     * Executa o vínculo entre o veículo e o proprietário
     *
     * @param idVeiculo
     * @param idProprietario
     */
//    public void vinculaVeiculoProprietario(Long idVeiculo, Long idProprietario) {
//        final Veiculo veiculo = getVeiculoById(idVeiculo);
//        final Proprietario proprietario = proprietarioService.getProprietarioById(idProprietario);
//        veiculo.setProprietario(proprietario);
//        proprietario.setId(proprietario.getId());
//        proprietarioService.save(proprietario);
//        veiculoRepository.save(veiculo);
//    }

    /**
     * Busca o veículo pelo id
     *
     * @param idVeiculo
     * @return Veiculo
     */
    public Veiculo getVeiculoById(Long idVeiculo) {
        return veiculoRepository.findById(idVeiculo)
                .orElseThrow(() -> new VeiculoNotFoundException("Veículo não encontrado."));
    }

    @Override
    public VeiculoOutputMapper convertToDto(Object input) {
        return veiculoMapper.convertToDto((Veiculo) input);
    }

    public Veiculo convertToEntity(Object input) {
        return veiculoMapper.convertToEntity((VeiculoInputMapper) input);
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
