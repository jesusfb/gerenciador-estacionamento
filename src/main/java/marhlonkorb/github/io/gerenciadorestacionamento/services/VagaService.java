/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VagaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * Permite adicionar veiculo a vaga se há vaga disponível(Em teste)
     *
     * @param idVeiculo
     * @param idVaga
     * @return vaga
     */
    public Vaga adicionarVeiculoVaga(Long idVeiculo, Long idVaga) {
        final Vaga vagaEncontrada = vagaRepository.findById(idVaga).orElse(new Vaga());
        final var veiculoEncontrado = veiculoRepository.findById(idVeiculo).get();
        if (vagaEncontrada.getVeiculo() == null && veiculoEncontrado.getVaga() == null && veiculoEncontrado.getPessoa() != null) {
            vagaEncontrada.setVeiculo(veiculoEncontrado);
            veiculoRepository.save(veiculoEncontrado);
        }
        vagaRepository.save(vagaEncontrada);
        return vagaEncontrada;
    }
}
