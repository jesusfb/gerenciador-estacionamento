package marhlonkorb.github.io.gerenciadorestacionamento.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public abstract class AbstractEntityController<T, ID, Input, DtoType> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    List<AbstractEntityService<T, ID, Input, DtoType>> entityServices;

    @GetMapping
    public List<Object> getAll() {
        return entityServices.stream()
                .flatMap(service -> service.getAll().stream())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional(rollbackFor = Exception.class)
    public DtoType getById(@PathVariable ID id) {
        return (DtoType) entityServices.stream()
                .map(service -> service.getById(id))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar a entidade com o ID " + id));
    }

    @GetMapping("/")
    public Page<DtoType> listEntities(Pageable pageable) {
        return (Page<DtoType>) repository.findAll(pageable);
    }

    @PostMapping
    public DtoType create(@RequestBody Input input) {
        return (DtoType) entityServices.stream()
                .map(service -> service.create(input))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Falha ao criar a entidade"));
    }

    @PutMapping("/{id}")
    public DtoType update(@PathVariable ID id, @RequestBody @Valid Input input) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Não foi possível encontrar a entidade com o ID " + id);
        }
        return (DtoType) entityServices.stream()
                .map(service -> service.update(id, input))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Falha ao atualizar a entidade"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Não foi possível excluir a entidade com o ID " + id);
        }
        entityServices.forEach(service -> service.delete(id));
    }
}
