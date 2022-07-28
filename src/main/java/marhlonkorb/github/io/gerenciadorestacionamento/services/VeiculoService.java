/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.Optional;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Responsável pelas regras de negócio do cadastro de veículos
 */
@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Autowired
    PessoaService pessoaService;

    /**
     * Cadastro de veículos caso seu id não exista
     *
     * @param veiculo
     */
    public void cadastrarVeiculo(Veiculo veiculo) {
        if (!veiculoRepository.existsById(veiculo.getPlaca_veiculo())) {
            veiculoRepository.save(veiculo);
        }
    }

    /**
     * Retorna um objeto Veiculo caso exista um cadastro
     *
     * @param id
     * @return Optional<Veiculo>
     */
    public Optional<Veiculo> getVeiculoPeloId(String id) {
        return veiculoRepository.findById(id);
    }

    /**
     * Exclui registro caso exista um id registrado no banco
     *
     * @param id
     */
    public void excluirVeículo(Veiculo veiculo, Pessoa pessoa) {
        if (isVeiculoCadastrado(veiculo.getPlaca_veiculo()) && !pessoaService.temVeiculocadastrado(pessoa, veiculo)) {
            veiculoRepository.deleteById(veiculo.getPlaca_veiculo());
        } else {
            System.out.println("Registro inexistente");
        }
    }

    /**
     * Retorna true se há um id registrado
     *
     * @param id
     * @return boolean
     */
    private boolean isVeiculoCadastrado(String id) {
        return veiculoRepository.existsById(id);
    }

    /**
     * Altera o cadastro do veículo
     *
     * @param id
     * @param veiculo
     */
    public void alterarVeiculo(String id, Veiculo veiculo, Pessoa pessoa) {
        if (isVeiculoCadastrado(id)) {
            veiculo.setPlaca_veiculo(id);
            veiculoRepository.save(veiculo);
        } else {
            System.out.println("Registro inexistente");
        }
    }
}
