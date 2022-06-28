package ua.com.alevel.vaccination_point.service;

import ua.com.alevel.vaccination_point.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity> {

    void create(E entity);

    void update(E entity);

    void delete(Long id);

    Optional<E> findById(Long id);

    List<E> findAll();

//    DataTableResponse<E> findAll(DataTableRequest request);

}
