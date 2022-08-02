/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.List;
import java.util.Optional;
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
    private VeiculoRepository veiculoRepository;

    /**
     * Cadastro de veículos caso seu id não exista
     *
     * @param veiculo
     */
    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    /**
     * Retorna lista de veículos cadastrados
     *
     * @return veiculo
     */
    public List<Veiculo> getListaVeiculos() {
        return veiculoRepository.findAll();
    }

    /**
     * Retorna um objeto Veiculo caso exista um cadastro
     *
     * @param id
     * @return Optional<Veiculo>
     */
    public Optional<Veiculo> getVeiculoPeloId(Integer id) {
        return veiculoRepository.findById(id);
    }

    /**
     * Exclui registro caso exista um id registrado no banco
     *
     * @param id
     */
    public boolean excluirVeículo(Integer id) {
        if (isVeiculoCadastrado(id)) {
            veiculoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Retorna true se há um id registrado de Veiculo
     *
     * @param id
     * @return boolean
     */
    public boolean isVeiculoCadastrado(Integer id) {
        return veiculoRepository.existsById(id);
    }

    /**
     * Altera o cadastro do veículo
     *
     * @param id
     * @param veiculo
     */
    public Veiculo alterarVeiculo(Integer id, Veiculo veiculo) {
        if (isVeiculoCadastrado(id)) {
            veiculo.setId_veiculo(id);
            veiculoRepository.save(veiculo);
            return veiculo;
        }
        return cadastrarVeiculo(veiculo);
    }
}
