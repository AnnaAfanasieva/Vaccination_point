package ua.com.alevel.vaccination_point.facade.item.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.item.NoteFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.NoteRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.NoteResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.service.item.NoteService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteFacadeImpl implements NoteFacade {

    private final NoteService noteService;

    public NoteFacadeImpl(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public void create(NoteRequestDto noteRequestDto) {
        Note note = ConvertRequestDtoToEntity.createNoteEntity(noteRequestDto, new Note());
        noteService.create(note);
    }

    @Override
    public void update(NoteRequestDto noteRequestDto, Long id) {
        Optional<Note> optionalNote = noteService.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createNoteEntity(noteRequestDto, note);
            noteService.update(note);
        }
    }

    @Override
    public void delete(Long id) {
        noteService.delete(id);
    }

    @Override
    public NoteResponseDto findById(Long id) {
        return new NoteResponseDto(noteService.findById(id).get());
    }

    @Override
    public List<NoteResponseDto> findAll() {
        //TODO переробити з використанням stream api
        List<NoteResponseDto> dtoList = new ArrayList<>();
        for (Note note : noteService.findAll()) {
            dtoList.add(new NoteResponseDto(note));
        }
//        List<NoteResponseDto> dtoList = noteService.findAll().stream().map(NoteResponseDto::new).toList();
        return dtoList;
    }
}
