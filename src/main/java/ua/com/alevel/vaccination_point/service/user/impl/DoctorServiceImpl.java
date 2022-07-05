package ua.com.alevel.vaccination_point.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.NoteRepository;
import ua.com.alevel.vaccination_point.dao.repository.item.VaccinationPointRepository;
import ua.com.alevel.vaccination_point.dao.repository.user.DoctorRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.user.DoctorService;
import ua.com.alevel.vaccination_point.service.util.CascadeDelete;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelperDoctor;
    private final NoteRepository noteRepository;
    private final CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelperNote;
    private final VaccinationPointRepository vaccinationPointRepository;
    private final CrudRepositoryHelper<VaccinationPoint, VaccinationPointRepository> crudRepositoryHelperVaccinationPoint;

    public DoctorServiceImpl(DoctorRepository doctorRepository,
                             CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelperDoctor,
                             NoteRepository noteRepository,
                             CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelperNote, VaccinationPointRepository vaccinationPointRepository, CrudRepositoryHelper<VaccinationPoint, VaccinationPointRepository> crudRepositoryHelperVaccinationPoint) {
        this.doctorRepository = doctorRepository;
        this.crudRepositoryHelperDoctor = crudRepositoryHelperDoctor;
        this.noteRepository = noteRepository;
        this.crudRepositoryHelperNote = crudRepositoryHelperNote;
        this.vaccinationPointRepository = vaccinationPointRepository;
        this.crudRepositoryHelperVaccinationPoint = crudRepositoryHelperVaccinationPoint;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(Doctor entity) {
        if (doctorRepository.existsByEmail(entity.getEmail())) {
            throw new RuntimeException("Користувач с такою поштою вже зареєстрований в системі");
        }
        crudRepositoryHelperDoctor.create(doctorRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(Doctor entity) {
        crudRepositoryHelperDoctor.update(doctorRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        Optional<Doctor> doctor = crudRepositoryHelperDoctor.findById(doctorRepository, id);
        if (doctor.isPresent()) {
            CascadeDelete.deleteAllNotesByDoctor(doctor.get(), crudRepositoryHelperNote, noteRepository);
//            Set<Note> notes = doctor.get().getNotes();
//            for (Note note : notes) {
//                crudRepositoryHelperNote.delete(noteRepository, note.getId());
//            }
            crudRepositoryHelperDoctor.delete(doctorRepository, id);
        } else {
            throw new RuntimeException("Запис для видалення відсутній");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> findById(Long id) {
        return crudRepositoryHelperDoctor.findById(doctorRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return crudRepositoryHelperDoctor.findAll(doctorRepository);
    }

    @Override
    public List<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint) {
        Optional<VaccinationPoint> optionalVaccinationPoint =
                crudRepositoryHelperVaccinationPoint.findById(vaccinationPointRepository, vaccinationPoint.getId());
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
