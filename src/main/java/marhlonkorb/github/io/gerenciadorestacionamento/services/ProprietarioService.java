package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.Proprietario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.ProprietarioInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.ProprietarioMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.ProprietarioOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Proprietario
 */
@Service
public class ProprietarioService extends AbstractEntityService<Proprietario, Long, ProprietarioInputMapper, ProprietarioOutputMapper> {
    @Autowired
    private ProprietarioMapper proprietarioMapper;

    @Autowired
    private PessoaRepository pessoaRepository;
    @Override
    public ProprietarioOutputMapper convertToDto(Object input) {
        return proprietarioMapper.convertToDto((Proprietario) input);
    }

    @Override
    public Proprietario convertToEntity(Object input) {
        return proprietarioMapper.convertToEntity((ProprietarioInputMapper) input);
    }
}
