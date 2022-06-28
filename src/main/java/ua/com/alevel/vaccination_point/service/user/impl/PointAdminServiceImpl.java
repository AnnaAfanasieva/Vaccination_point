package ua.com.alevel.vaccination_point.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.user.PointAdminRepository;
import ua.com.alevel.vaccination_point.model.entity.user.PointAdmin;
import ua.com.alevel.vaccination_point.service.user.PointAdminService;

import java.util.List;
import java.util.Optional;

@Service
public class PointAdminServiceImpl implements PointAdminService {

    private final PointAdminRepository pointAdminRepository;
    private final CrudRepositoryHelper<PointAdmin, PointAdminRepository> crudRepositoryHelper;

    public PointAdminServiceImpl(PointAdminRepository pointAdminRepository, CrudRepositoryHelper<PointAdmin, PointAdminRepository> crudRepositoryHelper) {
        this.pointAdminRepository = pointAdminRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(PointAdmin entity) {
        if (pointAdminRepository.existsByEmail(entity.getEmail())) {
            throw new RuntimeException("Користувач с такою поштою вже зареєстрований в системі");
        }
        crudRepositoryHelper.create(pointAdminRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(PointAdmin entity) {
        crudRepositoryHelper.update(pointAdminRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(pointAdminRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PointAdmin> findById(Long id) {
        return crudRepositoryHelper.findById(pointAdminRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PointAdmin> findAll() {
        return crudRepositoryHelper.findAll(pointAdminRepository);
    }
}
