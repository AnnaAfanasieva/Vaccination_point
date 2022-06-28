package ua.com.alevel.vaccination_point.service.item.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.NoteRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.service.item.NoteService;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelper;

    public NoteServiceImpl(NoteRepository noteRepository, CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelper) {
        this.noteRepository = noteRepository;
        this.crudRepositoryHelper = crudRepositoryHelper;
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
}
