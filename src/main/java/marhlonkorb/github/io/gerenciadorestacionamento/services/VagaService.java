/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Vaga
 */
@Service
public class VagaService extends AbstractEntityService<Vaga, Long, VagaInputMapper, VagaOutputMapper> {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VagaMapper vagaMapper;

    /**
     * Aplica regra para vincular ou não veículo a vaga
     *
//     * @param veiculo
//     * @param vaga
     * @return boolean
     */
//    private boolean isDeveVincularVeiculoVaga(Veiculo veiculo, Vaga vaga) {
//        return vaga.getVeiculo() == null && veiculo.getVaga() == null && veiculo.getPessoa() != null;
//    }
//
//    private void removerVeiculoVagaAnterior(Veiculo veiculo) {
//        if (veiculo.getVaga() != null) {
//            final var vagaEncontrada = vagaRepository.findById(veiculo.getVaga().getId()).get();
//            vagaEncontrada.setVeiculo(null);
//            vagaRepository.save(vagaEncontrada);
//            veiculo.setVaga(null);
//            veiculoRepository.save(veiculo);
//        }
//    }
//
//    /**
//     * Permite adicionar veiculo a vaga se há vaga disponível(Em teste)
//     *
//     * @param idVeiculo
//     * @param idVaga
//     * @return vaga
//     */
//    public void vincularVeiculoVaga(Long idVeiculo, Long idVaga) {
//        final Vaga vagaEncontrada = vagaRepository.findById(idVaga).get();
//        final var veiculoEncontrado = veiculoRepository.findById(idVeiculo).get();
//        removerVeiculoVagaAnterior(veiculoEncontrado);
//        if (isDeveVincularVeiculoVaga(veiculoEncontrado, vagaEncontrada)) {
//            veiculoEncontrado.setVaga(vagaEncontrada);
//            veiculoRepository.save(veiculoEncontrado);
//            vagaEncontrada.setVeiculo(veiculoEncontrado);
//        }
//        vagaRepository.save(vagaEncontrada);
//    }

    @Override
    public VagaOutputMapper convertToDto(Object input) {
        return vagaMapper.convertToDto((Vaga) input);
    }

    @Override
    public Vaga convertToEntity(Object input) {
        return vagaMapper.convertToEntity((VagaInputMapper) input);
    }
}
