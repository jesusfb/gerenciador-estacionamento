package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaOutputMapper;
import org.springframework.stereotype.Component;

@Component
public class VagaMapper extends AbstractEntityMapper<Vaga, VagaInputMapper, VagaOutputMapper> {

    @Override
    public VagaOutputMapper convertToDto(Vaga input) {
        return null;
    }

    @Override
    public Vaga convertToEntity(VagaInputMapper vagaInputMapper) {
        return null;
    }
}
