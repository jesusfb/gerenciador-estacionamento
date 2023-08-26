/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.Proprietario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.ProprietarioRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Veiculo
 */
@Service
public class VeiculoService extends AbstractEntityService<Veiculo, Long, VeiculoInputMapper, VeiculoOutputMapper> {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Autowired
    private VeiculoMapper veiculoMapper;

    /**
     * Adiciona o id de Proprietario a tabela de veiculo se o veículo e a proprietario estão cadastrados
     *
     * @param veiculo
     * @param proprietario
     * @return boolean
     */
    public boolean adicionarVeiculoCadastrado(Veiculo veiculo, Proprietario proprietario) {
        if (proprietarioRepository.existsById(proprietario.getId()) &&
                veiculoRepository.existsById(veiculo.getId())) {
            veiculo.setPessoa(proprietario);
            proprietario.setId(proprietario.getId());
            proprietarioRepository.save(proprietario);
            veiculoRepository.save(veiculo);
            return true;
        }
        return false;
    }

    @Override
    public VeiculoOutputMapper convertToDto(Object input) {
        return veiculoMapper.convertToDto((Veiculo) input);
    }

    public Veiculo convertToEntity(Object input) {
        return veiculoMapper.convertToEntity((VeiculoInputMapper) input);
    }
}
