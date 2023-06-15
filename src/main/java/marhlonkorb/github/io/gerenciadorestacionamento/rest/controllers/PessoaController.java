/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityController;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaOutputMapper;
import org.springframework.web.bind.annotation.*;

/**
 * Controla as requisições da entidade Pessoa
 */
@RestController
@RequestMapping("pessoa")
public class PessoaController extends AbstractEntityController<Pessoa, Long, PessoaInputMapper, PessoaOutputMapper> {

}
