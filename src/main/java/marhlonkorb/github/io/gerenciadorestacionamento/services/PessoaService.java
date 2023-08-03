package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.Optional;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadecomid.EntidadeComId;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

/**
 * Service da entidade Pessoa
 */
@Service
public class PessoaService extends AbstractEntityService<Pessoa, Long, PessoaInputMapper, PessoaOutputMapper> {
    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private PessoaRepository pessoaRepository;
    @Override
    public PessoaOutputMapper convertToDto(Object input) {
        return pessoaMapper.convertToDto((Pessoa) input);
    }

    @Override
    public Pessoa convertToEntity(Object input) {
        return pessoaMapper.convertToEntity((PessoaInputMapper) input);
    }
}
