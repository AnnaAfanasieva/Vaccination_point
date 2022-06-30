package ua.com.alevel.vaccination_point.service.user.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.NoteRepository;
import ua.com.alevel.vaccination_point.dao.repository.user.DoctorRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.user.DoctorService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelperDoctor;
    private final NoteRepository noteRepository;
    private final CrudRepositoryHelper<Note, NoteRepository> noteCrudRepositoryHelperNote;

    public DoctorServiceImpl(DoctorRepository doctorRepository, CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelperDoctor, NoteRepository noteRepository, CrudRepositoryHelper<Note, NoteRepository> noteCrudRepositoryHelperNote) {
        this.doctorRepository = doctorRepository;
        this.crudRepositoryHelperDoctor = crudRepositoryHelperDoctor;
        this.noteRepository = noteRepository;
        this.noteCrudRepositoryHelperNote = noteCrudRepositoryHelperNote;
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
            Set<Note> notes = doctor.get().getNotes();
            for (Note note : notes) {
                noteCrudRepositoryHelperNote.delete(noteRepository, note.getId());
            }
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
}
