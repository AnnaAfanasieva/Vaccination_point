package ua.com.alevel.vaccination_point.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.user.DoctorRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.item.NoteService;
import ua.com.alevel.vaccination_point.service.item.VaccinationPointService;
import ua.com.alevel.vaccination_point.service.user.DoctorService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelper;
    private final NoteService noteService;
    private final VaccinationPointService vaccinationPointService;

    public DoctorServiceImpl(DoctorRepository doctorRepository,
                             CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelper,
                             NoteService noteService,
                             VaccinationPointService vaccinationPointService) {
        this.doctorRepository = doctorRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
        this.noteService = noteService;
        this.vaccinationPointService = vaccinationPointService;
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
        Optional<Doctor> doctor = crudRepositoryHelper.findById(doctorRepository, id);
        if (doctor.isPresent()) {
            Set<Note> notes = doctor.get().getNotes();
            for (Note note : notes) {
                noteService.delete(note.getId());
            }
            crudRepositoryHelper.delete(doctorRepository, id);
        } else {
            throw new RuntimeException("Запис для видалення відсутній");
        }
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

    @Override
    public List<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint) {
        Optional<VaccinationPoint> optionalVaccinationPoint = vaccinationPointService.findById(vaccinationPoint.getId());
        if (optionalVaccinationPoint.isPresent()) {
            return doctorRepository.findAllByVaccinationPoint(vaccinationPoint);
        } else {
         throw new RuntimeException("Такого запису не існує");
        }
    }

    @Override
    public Optional<Doctor> findByIdAndVisible(Long id, boolean isVisible) {
        if (doctorRepository.existsById(id)) {
            return doctorRepository.findByIdAndVisible(id, isVisible);
        } else {
            throw new RuntimeException("Дана сутність не знайдена");
        }
    }

    @Override
    public List<Doctor> findAllByVisible(boolean isVisible) {
        return doctorRepository.findAllByVisible(isVisible);
    }
}
