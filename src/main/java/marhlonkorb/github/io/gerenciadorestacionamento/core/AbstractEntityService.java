package marhlonkorb.github.io.gerenciadorestacionamento.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class AbstractEntityService<T, ID, DtoType> extends AbstractEntityMapper {

    @Autowired
    private JpaRepository<T, ID> repository;

    public List<Object> getAll() {
        List<T> entities = repository.findAll();
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public DtoType getById(ID id) {
        T entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar a entidade com o ID " + id));
        return (DtoType) convertToDto(entity);
    }

    public Page<DtoType> listEntities(Pageable pageable) {
        List<T> entities = (List<T>) repository.findAll(pageable);
        return (Page<DtoType>) ((Page<T>) entities).map(this::convertToDto);
    }

    public DtoType create(T entity) {
        T savedEntity = repository.save(entity);
        return (DtoType) convertToDto(savedEntity);
    }

    public DtoType update(ID id, T entity) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Não foi possível encontrar a entidade com o ID " + id);
        }
        T savedEntity = repository.save(entity);
        return (DtoType) convertToDto(savedEntity);
    }

    public void delete(ID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Não foi possível excluir a entidade com o ID " + id);
        }
        repository.deleteById(id);
    }

}
