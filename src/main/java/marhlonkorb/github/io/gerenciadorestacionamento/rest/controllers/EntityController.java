package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toMap;

@RestController
public abstract class EntityController<T, ID> {

    @Autowired
    private CrudRepository<T, ID> repository;

    @GetMapping
    public List<T> getAll() {
        return ((List<T>) repository.findAll());
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable ID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar a entidade com o ID " + id));
    }

    @PostMapping
    public T create(@RequestBody @Valid T entity) {
        return repository.save(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody @Valid T entity) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Não foi possível encontrar a entidade com o ID ".concat(id.toString()));
        }
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Não foi possível excluir a entidade com o ID ".concat(id.toString()).concat(". Verifique."));
        }
        repository.deleteById(id);
    }
}
