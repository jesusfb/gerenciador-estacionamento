/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.EstacionamentoRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsável por implementar as regras de negócio do cadastro de veículos no estacionamento
 */
@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

}
