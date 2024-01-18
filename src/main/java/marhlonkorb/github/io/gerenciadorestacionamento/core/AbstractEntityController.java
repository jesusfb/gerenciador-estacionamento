package marhlonkorb.github.io.gerenciadorestacionamento.core;

import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadecomid.EntidadeComId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public abstract class AbstractEntityController<T, ID, Input, DtoType> {
    @Autowired
    List<AbstractEntityService<T, ID, Input, DtoType>> entitiesServices;

    @GetMapping("/all")
    public List<Object> getAll() {
        return entitiesServices.stream()
                .flatMap(service -> service.getAll().stream())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional(rollbackFor = Exception.class)
    public DtoType getById(@PathVariable ID id) {
        return (DtoType) entitiesServices.stream()
                .map(service -> service.getById(id)).findFirst().get();
    }

    @GetMapping
    public Page<DtoType> listEntities(Pageable pageable) {
        List<DtoType> dtoList = entitiesServices.stream()
                .flatMap(service -> service.getPageable(pageable).getContent().stream())
                .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, dtoList.size());
    }

    @PostMapping
    public DtoType create(@RequestBody Input input) {
        return (DtoType) entitiesServices.stream()
                .map(service -> service.create(input))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Falha ao criar a entidade"));
    }

    @PutMapping("/{id}")
    public DtoType update(@PathVariable ID id, @RequestBody Input input) {
        return  (DtoType) entitiesServices.stream()
                .map(service -> service.update(id, input)).findFirst().get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        entitiesServices.forEach(service -> service.delete(id));
    }
}
