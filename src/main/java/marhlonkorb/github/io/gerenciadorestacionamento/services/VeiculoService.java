/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.List;
import java.util.Optional;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
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
    private PessoaRepository pessoaRepository;

    @Autowired
    private VeiculoMapper veiculoMapper;

    /**
     * Adiciona o id de Pessoa a tabela de veiculo se o veículo e a pessoa estão cadastrados
     *
     * @param veiculo
     * @param pessoa
     * @return boolean
     */
    public boolean adicionarVeiculoCadastrado(Veiculo veiculo, Pessoa pessoa) {
        if (pessoaRepository.existsById(pessoa.getId()) &&
                veiculoRepository.existsById(veiculo.getId())) {
            veiculo.setPessoa(pessoa);
            pessoa.setId(pessoa.getId());
            pessoaRepository.save(pessoa);
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
