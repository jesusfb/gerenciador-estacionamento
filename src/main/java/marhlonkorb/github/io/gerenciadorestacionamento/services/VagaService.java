/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.List;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VagaRepository;

/**
 * Classe responsável por implementar as regras de negócio do cadastro de veículos no estacionamento
 */
@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    /**
     * Permite adicionar veiculo a vaga se há vaga disponível(Em desenvolvimento)
     *
     * @param veiculo
     * @param vaga
     * @return vaga
     */
    public Vaga adicionarVeiculoVaga(@PathVariable Veiculo veiculo, Vaga vaga) {
        if (!veiculoRepository.existsById(veiculo.getId_veiculo()) &&
                !vagaRepository.existsById(vaga.getId_vaga()) &&
                veiculoRepository.existsById(veiculo.getPessoa().getId_pessoa())) {
            vaga.setVeiculo(veiculo);
            veiculo.setId_veiculo(veiculo.getId_veiculo());
            vagaRepository.save(vaga);
            veiculoRepository.save(veiculo);
            return vaga;
        }
        return vaga;
    }

    /**
     * Lista as vagas totais no estacionamento
     *
     * @return List Vaga
     */
    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
    }

}
