package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.Optional;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadecomid.EntidadeComId;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends AbstractEntityService<Pessoa, Long, PessoaOutputMapper> {
    @Override
    public PessoaOutputMapper convertToDto(Object input) {
        PessoaOutputMapper pessoaOutputMapper = new PessoaOutputMapper();
        pessoaOutputMapper.setNome("Jandir");
        return pessoaOutputMapper;
    }

    @Override
    public Pessoa convertToEntity(Object o) {
        return null;
    }
}
