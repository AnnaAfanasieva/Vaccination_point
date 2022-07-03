package ua.com.alevel.vaccination_point.service.item.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.VaccinationPointRepository;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.item.VaccinationPointService;
import ua.com.alevel.vaccination_point.service.user.DoctorService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VaccinationPointServiceImpl implements VaccinationPointService {

    private final VaccinationPointRepository vaccinationPointRepository;
    private final CrudRepositoryHelper<VaccinationPoint, VaccinationPointRepository> crudRepositoryHelper;
    private final DoctorService doctorService;

    public VaccinationPointServiceImpl(VaccinationPointRepository vaccinationPointRepository,
                                       CrudRepositoryHelper<VaccinationPoint, VaccinationPointRepository> crudRepositoryHelper,
                                       DoctorService doctorService) {
        this.vaccinationPointRepository = vaccinationPointRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
        this.doctorService = doctorService;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(VaccinationPoint entity) {
        crudRepositoryHelper.create(vaccinationPointRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(VaccinationPoint entity) {
        crudRepositoryHelper.update(vaccinationPointRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        Optional<VaccinationPoint> vaccinationPoint = crudRepositoryHelper.findById(vaccinationPointRepository, id);
        if (vaccinationPoint.isPresent()) {
            Set<Doctor> doctors = vaccinationPoint.get().getDoctors();
            for (Doctor doctor : doctors) {
                if (doctor.getRoleType().name().equals("ROLE_DOCTOR")) {
                    doctorService.delete(doctor.getId());
                }
            }
            crudRepositoryHelper.delete(vaccinationPointRepository, id);
        } else {
            throw new RuntimeException("Запис для видалення відсутній");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VaccinationPoint> findById(Long id) {
        return crudRepositoryHelper.findById(vaccinationPointRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VaccinationPoint> findAll() {
        return crudRepositoryHelper.findAll(vaccinationPointRepository);
    }

    @Override
    public Optional<VaccinationPoint> findByIdAndVisible(Long id, boolean isVisible) {
        if (vaccinationPointRepository.existsById(id)) {
            return vaccinationPointRepository.findByIdAndVisible(id, isVisible);
        } else {
            throw new RuntimeException("Дана сутність не знайдена");
        }
    }

    @Override
    public List<VaccinationPoint> findAllByVisible(boolean isVisible) {
        return vaccinationPointRepository.findAllByVisible(isVisible);
    }
}
