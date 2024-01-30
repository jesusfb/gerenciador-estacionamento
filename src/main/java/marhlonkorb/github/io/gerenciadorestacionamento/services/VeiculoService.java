/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.VeiculoOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.exceptions.VeiculoNotFoundException;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

// Resto do seu código...


import java.util.Set;

/**
 * Service da entidade Veiculo
 */
@Service
public class VeiculoService extends AbstractEntityService<Veiculo, Long, VeiculoInputMapper, VeiculoOutputMapper> {

    private final VeiculoRepository veiculoRepository;

    private final VeiculoMapper veiculoMapper;
    private final ModelMapper modelMapper;

    public VeiculoService(VeiculoRepository veiculoRepository, VeiculoMapper veiculoMapper, ModelMapper modelMapper) {
        this.veiculoRepository = veiculoRepository;
        this.veiculoMapper = veiculoMapper;
        this.modelMapper = modelMapper;
    }

    /**
     * Busca o veículo pelo id
     *
     * @param idVeiculo
     * @return Veiculo
     */
    public Veiculo getVeiculoById(Long idVeiculo) {
        return veiculoRepository.findById(idVeiculo)
                .orElseThrow(() -> new VeiculoNotFoundException("Veículo não encontrado."));
    }

    @Override
    public VeiculoOutputMapper convertToDto(Object input) {
        return veiculoMapper.convertToDto((Veiculo) input);
    }

    @Override
    public Veiculo convertToEntity(Object input) {
        return veiculoMapper.convertToEntity((VeiculoInputMapper) input);
    }

    /**
     * Busca todos os veículos associados a um proprietário pelo seu ID.
     *
     * @param idProprietario O ID do proprietário para o qual os veículos serão recuperados.
     * @return Um conjunto (Set) de objetos VeiculoOutputMapper representando os veículos do proprietário.
     */
    public Set<VeiculoOutputMapper> findAllByIdProprietario(Long idProprietario) {
        // Recupera os veículos associados ao proprietário do repositório
        final Set<Veiculo> veiculosProprietario = veiculoRepository.findAllByProprietarioId(idProprietario);
        // Realiza o mapeamento dos veículos para objetos do tipo VeiculoOutputMapper usando o ModelMapper
        // O uso de TypeToken ajuda a lidar com a natureza genérica da coleção Set<VeiculoOutputMapper>
        return modelMapper.map(veiculosProprietario, new TypeToken<Set<VeiculoOutputMapper>>() {
        }.getType());
    }

    /**
     * Marca um veículo como principal para um determinado proprietário.
     * <p>
     * Busca todos os veículos associados a um proprietário com base no ID do proprietário,
     * atualiza os status dos veículos e salva as alterações no repositório.
     *
     * @param veiculo veículo que será marcado como principal.
     */
    public void selecionaComoPrincipal(VeiculoInputMapper veiculo) {
        // Atualiza os status dos veículos
        atualizaStatusVeiculo(veiculo);
        // Busca todos os veículos associados ao proprietário pelo ID do proprietário
        Set<Veiculo> veiculosEncontrados = veiculoRepository.findAllByProprietarioId(veiculo.getIdProprietario());
        // Percorre os veículos encontrados
        veiculosEncontrados.stream().forEach(v -> {
            // Se o id do veículo não for igual ao id do veículo que está sendo atualizado
            if (!v.getId().equals(veiculo.getId())) {
                v.setPrincipal(false);
            }
        });
        veiculoRepository.saveAll(veiculosEncontrados);
    }

    /**
     * Atualiza os status dos veículos, desmarcando todos como não principais e marcando o específico como principal.
     */
    private void atualizaStatusVeiculo(VeiculoInputMapper veiculo) {
        final Veiculo veiculoEncontrado = veiculoRepository.findById(veiculo.getId()).get();
        veiculoEncontrado.setPrincipal(!veiculo.isPrincipal());
        veiculoRepository.save(veiculoEncontrado);
    }

}
