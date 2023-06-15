package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaOutputMapper;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper extends AbstractEntityMapper<Veiculo, VeiculoInputMapper, VeiculoOutputMapper> {
    @Override
    public VeiculoOutputMapper convertToDto(Veiculo input) {
        return null;
    }

    @Override
    public Veiculo convertToEntity(VeiculoInputMapper veiculoInputMapper) {
        return null;
    }
}
