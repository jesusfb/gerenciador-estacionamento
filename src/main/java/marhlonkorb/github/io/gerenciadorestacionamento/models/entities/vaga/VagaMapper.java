package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VagaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VagaMapper extends AbstractEntityMapper<Vaga, VagaInputMapper, VagaOutputMapper> {

    @Autowired
    VagaRepository vagaRepository;

    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public VagaOutputMapper convertToDto(Vaga input) {
        return modelMapper.map(input, VagaOutputMapper.class);
    }

    @Override
    public Vaga convertToEntity(VagaInputMapper input) {
//        final Vaga vagasEncontrada = vagaRepository.findById(input.getId()).get();
//        vinculaEntidades(input.getIdVeiculo(), vagasEncontrada);
//        vagasEncontrada.setId(input.getId());
        return new Vaga();
    }

    /**
     * Realiza a vinculação ou remoção do vínculo entre as entidades Vaga e Veículo
     *
     * @param id
     * @param vaga
     */
    private void vinculaEntidades(Long id, Vaga vaga) {
        if (id != null) {
            final Veiculo veiculoEncontrado = veiculoRepository.findById(id).get();
            vaga.setVeiculo(veiculoEncontrado);
        } else {
            vaga.setVeiculo(null);
        }
    }
}
