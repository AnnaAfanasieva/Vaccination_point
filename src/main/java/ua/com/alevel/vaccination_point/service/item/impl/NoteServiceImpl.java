package ua.com.alevel.vaccination_point.service.item.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.NoteRepository;
import ua.com.alevel.vaccination_point.dao.repository.item.VaccineRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.service.item.NoteService;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelper;
    private final VaccineRepository vaccineRepository;

    public NoteServiceImpl(NoteRepository noteRepository,
                           CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelper,
                           VaccineRepository vaccineRepository) {
        this.noteRepository = noteRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(Note entity) {
        crudRepositoryHelper.create(noteRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(Note entity) {
        crudRepositoryHelper.update(noteRepository, entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Long id) {
        crudRepositoryHelper.delete(noteRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Note> findById(Long id) {
        return crudRepositoryHelper.findById(noteRepository, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Note> findAll() {
        return crudRepositoryHelper.findAll(noteRepository);
    }

    @Override
    public List<Note> findAllByVaccine(Vaccine vaccine) {
        Optional<Vaccine> optionalVaccine = vaccineRepository.findById(vaccine.getId());
        if (optionalVaccine.isPresent()) {
            return noteRepository.findAllByVaccine(vaccine);
        } else {
            throw new RuntimeException("Такого запису не існує");
        }
    }

    @Override
    public Optional<Note> findByIdAndVisible(Long id, boolean isVisible) {
        if(noteRepository.existsById(id)) {
            return noteRepository.findByIdAndVisible(id, isVisible);
        } else {
            throw new RuntimeException("Дана сутність не знайдена");
        }
    }

    @Override
    public List<Note> findAllByVisible(boolean isVisible) {
        return noteRepository.findAllByVisible(isVisible);
    }
}
