package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.rest.exception.ApiErrors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    /**
     * Erro será captado através da annotation @Valid e armazenado em exception, onde será armazenado
     * em uma lista de erros dentro em um objeto bindResult
     *
     * @return new ApiErrors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<String> messages = bindingResult.getAllErrors().
                stream().
                map(DefaultMessageSourceResolvable::getDefaultMessage).
                collect(Collectors.toList());
        return new ApiErrors(messages);
    }

    /**
     * Tratar as exceções
     *
     * @return new ResponseEntity
     */

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException exception) {
        String mensagemErro = exception.getMessage();
        HttpStatus codigoStatus = exception.getStatus();
        ApiErrors apiErrors = new ApiErrors(mensagemErro);
        return new ResponseEntity(apiErrors, codigoStatus);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        String errorMessage = "A entidade não foi encontrada.";
        return buildResponseEntity(new ApiErrors(HttpStatus.NOT_FOUND, errorMessage, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiErrors apiErrors) {
        return new ResponseEntity<>(apiErrors, apiErrors.getStatus());
    }
}
