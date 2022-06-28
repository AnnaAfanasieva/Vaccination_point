package ua.com.alevel.vaccination_point.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.user.DoctorRepository;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.user.DoctorService;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelper) {
        this.doctorRepository = doctorRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(Doctor entity) {
        if (doctorRepository.existsByEmail(entity.getEmail())) {
            throw new RuntimeException("Користувач с такою поштою вже зареєстрований в системі");
        }
        crudRepositoryHelper.create(doctorRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(Doctor entity) {
        crudRepositoryHelper.update(doctorRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(doctorRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> findById(Long id) {
        return crudRepositoryHelper.findById(doctorRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return crudRepositoryHelper.findAll(doctorRepository);
    }
}