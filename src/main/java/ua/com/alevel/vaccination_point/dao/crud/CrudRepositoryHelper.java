package ua.com.alevel.vaccination_point.dao.crud;

import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepositoryHelper<E extends BaseEntity, R extends BaseRepository<E>> {

    void create(R repository, E entity);

    void update(R repository, E entity);

    void delete(R repository, Long id);

    Optional<E> findById(R repository, Long id);

    List<E> findAll(R repository);

//        DataTableResponse<E> findAll(R repository, DataTableRequest request);
}