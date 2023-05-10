/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.List;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VagaRepository;

/**
 * Classe responsável por implementar as regras de negócio do cadastro de veículos no estacionamento
 */
@Service
public class VagaService {

    @Autowired
    private final VagaRepository vagaRepository;

    @Autowired
    private final VeiculoRepository veiculoRepository;

    public VagaService(VagaRepository vagaRepository, VeiculoRepository veiculoRepository) {
        this.vagaRepository = vagaRepository;
        this.veiculoRepository = veiculoRepository;
    }

    /**
     * Permite adicionar veiculo a vaga se há vaga disponível(Em desenvolvimento)
     *
     * @param veiculo
     * @param vaga
     * @return vaga
     */
    public Vaga adicionarVeiculoVaga(Veiculo veiculo, Vaga vaga) {
        if (!veiculoRepository.existsById(veiculo.getId())&&
                veiculoRepository.existsById(veiculo.getPessoa().getId())) {
            vaga.setVeiculo(veiculo);
            veiculo.setId(veiculo.getId());
            vaga.setId(vaga.getId());
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
    public List<Vaga> getAll() {
        return vagaRepository.findAll();
    }

}
