/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.List;
import java.util.Optional;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Responsável pelas regras de negócio do cadastro de veículos
 */
@Service
public class VeiculoService {

    @Autowired
    private final VeiculoRepository veiculoRepository;

    @Autowired
    private final PessoaRepository pessoaRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, PessoaRepository pessoaRepository) {
        this.veiculoRepository = veiculoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    /**
     * Cadastro de veículos caso seu id não exista
     *
     * @param veiculo
     * @return veiculo
     */
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    /**
     * Retorna lista de veículos cadastrados
     *
     * @return veiculo
     */
    public List<Veiculo> getVeiculos() {
        return veiculoRepository.findAll();
    }

    /**
     * Retorna um objeto Veiculo caso exista um cadastro
     *
     * @param id
     * @return Optional<Veiculo>
     */
    public Optional<Veiculo> getById(Long id) {
        return veiculoRepository.findById(id);
    }

    /**
     * Exclui registro caso exista um id registrado no banco
     *
     * @param id
     */
    public void excluirVeículo(Long id) {
        if (isExists(id)) {
            veiculoRepository.deleteById(id);
        }
    }

    /**
     * Retorna se há um id registrado de Veiculo
     *
     * @param id
     * @return boolean
     */
    public boolean isExists(Long id) {
        return veiculoRepository.existsById(id);
    }

    /**
     * Altera o cadastro do veículo
     *
     * @param veiculo
     */
    public void alterarVeiculo(Veiculo veiculo) {
        if (isExists(veiculo.getId())) {
            veiculoRepository.save(veiculo);
            return;
        }
        cadastrarVeiculo(veiculo);
    }

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
}
