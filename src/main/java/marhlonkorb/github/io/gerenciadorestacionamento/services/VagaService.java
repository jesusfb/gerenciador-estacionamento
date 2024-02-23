/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.IGenericEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.VagaOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.repositories.VagaRepository;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Vaga
 */
@Service
public class VagaService extends IGenericEntityService<Vaga, Long, VagaInputMapper, VagaOutputMapper> {

    private final VagaMapper vagaMapper;
    private final VagaRepository vagaRepository;

    public VagaService(VagaMapper vagaMapper, VagaRepository vagaRepository) {
        this.vagaMapper = vagaMapper;
        this.vagaRepository = vagaRepository;
    }

    @Override
    public VagaOutputMapper convertToDto(Vaga input) {
        return vagaMapper.convertToDto(input);
    }

    @Override
    public Vaga convertToEntity(VagaInputMapper input) {
        return vagaMapper.convertToEntity(input);
    }

    /**
     * Busca o proprietário pelo id
     *
     * @param idVaga
     * @return Proprietario
     */
    public Vaga getVagaById(Long idVaga) {
        return vagaRepository.findById(idVaga)
                .orElseThrow(() -> new InvalidDataAccessApiUsageException("Vaga não encontrada."));
    }

    public Vaga save(Vaga vaga){
        return vagaRepository.save(vaga);
    }
}
