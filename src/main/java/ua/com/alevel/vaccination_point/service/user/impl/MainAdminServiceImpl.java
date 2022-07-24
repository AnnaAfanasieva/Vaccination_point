package ua.com.alevel.vaccination_point.service.user.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.user.MainAdminRepository;
import ua.com.alevel.vaccination_point.model.entity.user.MainAdmin;
import ua.com.alevel.vaccination_point.service.user.MainAdminService;

import java.util.List;
import java.util.Optional;

@Service
public class MainAdminServiceImpl implements MainAdminService {

    private final MainAdminRepository mainAdminRepository;
    private final CrudRepositoryHelper<MainAdmin, MainAdminRepository> crudRepositoryHelper;
    private final BCryptPasswordEncoder encoder;

    public MainAdminServiceImpl(MainAdminRepository mainAdminRepository, CrudRepositoryHelper<MainAdmin, MainAdminRepository> crudRepositoryHelper, BCryptPasswordEncoder encoder) {
        this.mainAdminRepository = mainAdminRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
        this.encoder = encoder;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(MainAdmin entity) {
        if (mainAdminRepository.existsByEmail(entity.getEmail())) {
            throw new RuntimeException("Користувач с такою поштою вже зареєстрований в системі");
        }
        entity.setPassword(encoder.encode(entity.getPassword()));
        crudRepositoryHelper.create(mainAdminRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(MainAdmin entity) {
        crudRepositoryHelper.update(mainAdminRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(mainAdminRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MainAdmin> findById(Long id) {
        return crudRepositoryHelper.findById(mainAdminRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MainAdmin> findAll() {
        return crudRepositoryHelper.findAll(mainAdminRepository);
    }
}
