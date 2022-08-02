/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Estacionamento;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.EstacionamentoRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Classe responsável por implementar as regras de negócio do cadastro de veículos no estacionamento
 */
@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Estacionamento adicionarVeiculoVaga(@PathVariable Veiculo veiculo, Estacionamento estacionamento) {
        if (!veiculoRepository.existsById(veiculo.getId_veiculo()) &&
                !estacionamentoRepository.existsById(estacionamento.getId_vaga())) {
            estacionamento.setVeiculo(veiculo);
            veiculo.setId_veiculo(veiculo.getId_veiculo());
            estacionamentoRepository.save(estacionamento);
            veiculoRepository.save(veiculo);
            return estacionamento;
        }
        return estacionamento;
    }

}
