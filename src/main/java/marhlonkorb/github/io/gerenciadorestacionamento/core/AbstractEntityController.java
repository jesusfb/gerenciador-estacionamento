package marhlonkorb.github.io.gerenciadorestacionamento.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public abstract class AbstractEntityController<T, ID, Input, DtoType> {
    @Autowired
    List<AbstractEntityService<T, ID, Input, DtoType>> entitiesServices;

    @GetMapping
    public List<Object> getAll() {
        return entitiesServices.stream()
                .flatMap(service -> service.getAll().stream())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional(rollbackFor = Exception.class)
    public DtoType getById(@PathVariable ID id) {
        return (DtoType) entitiesServices.stream()
                .map(service -> service.getById(id));
    }

    @GetMapping("/")
    public Page<DtoType> listEntities(Pageable pageable) {
        return (Page<DtoType>) entitiesServices.stream().map(service -> service.getPageable(pageable)) ;
    }

    @PostMapping
    public DtoType create(@RequestBody @Valid Input input) {
        return (DtoType) entitiesServices.stream()
                .map(service -> service.create(input))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Falha ao criar a entidade"));
    }

    @PutMapping("/{id}")
    public DtoType update(@PathVariable ID id, @RequestBody @Valid Input input) {
        return (DtoType) entitiesServices.stream()
                .map(service -> service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        entitiesServices.forEach(service -> service.delete(id));
    }
}
