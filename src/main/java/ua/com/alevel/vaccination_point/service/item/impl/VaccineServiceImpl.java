package ua.com.alevel.vaccination_point.service.item.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.VaccineRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.service.item.VaccineService;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;
    private final CrudRepositoryHelper<Vaccine, VaccineRepository> crudRepositoryHelper;

    public VaccineServiceImpl(VaccineRepository vaccineRepository, CrudRepositoryHelper<Vaccine, VaccineRepository> crudRepositoryHelper) {
        this.vaccineRepository = vaccineRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(Vaccine entity) {
        crudRepositoryHelper.create(vaccineRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(Vaccine entity) {
        crudRepositoryHelper.update(vaccineRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(vaccineRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Vaccine> findById(Long id) {
        return crudRepositoryHelper.findById(vaccineRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vaccine> findAll() {
        return crudRepositoryHelper.findAll(vaccineRepository);
    }
}
