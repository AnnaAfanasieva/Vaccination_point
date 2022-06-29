package ua.com.alevel.vaccination_point.dao.crud.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.BaseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class CrudRepositoryHelperImpl<
        E extends BaseEntity,
        R extends BaseRepository<E>>
        implements CrudRepositoryHelper<E, R> {

    @Override
    public void create(R repository, E entity) {
        repository.save(entity);
    }

    @Override
    public void update(R repository, E entity) {
        checkExist(repository, entity.getId());
        repository.save(entity);
    }

    @Override
    public void delete(R repository, Long id) {
        checkExist(repository, id);
        E entity = repository.getById(id);
        entity.setVisible(false);
        repository.save(entity);
    }

    @Override
    public Optional<E> findById(R repository, Long id) {
        checkExist(repository, id);
        return repository.findById(id);
    }

    @Override
    public List<E> findAll(R repository) {
        return repository.findAll();
    }

//    @Override
//    public DataTableResponse<E> findAll(R repository, DataTableRequest request) {
//        Sort sort = request.getOrder().equals("desc")
//                ? Sort.by(request.getSort()).descending()
//                : Sort.by(request.getSort()).ascending();
//        Page<E> entityPage = repository.findAll(
//                PageRequest.of(request.getPage() - 1, request.getSize(), sort));
//        DataTableResponse<E> dataTableResponse = new DataTableResponse<>();
//        dataTableResponse.setCurrentPage(request.getPage());
//        dataTableResponse.setPageSize(request.getSize());
//        dataTableResponse.setOrder(request.getOrder());
//        dataTableResponse.setSort(request.getSort());
//        dataTableResponse.setItemsSize(entityPage.getTotalElements());
//        dataTableResponse.setTotalPages(entityPage.getTotalPages());
//        dataTableResponse.setItems(entityPage.getContent());
//        return dataTableResponse;
//    }

    private void checkExist(R repository, Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Дана сутність не знайдена");
        }
    }
}
