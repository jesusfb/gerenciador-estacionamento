/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityController;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.Proprietario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.ProprietarioDbConstantes;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.ProprietarioInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.ProprietarioOutputMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controla as requisições da entidade Proprietario
 */
@RestController
@RequestMapping(ProprietarioDbConstantes.TABLE_NAME)
public class ProprietarioController extends AbstractEntityController<Proprietario, Long, ProprietarioInputMapper, ProprietarioOutputMapper> {
}
