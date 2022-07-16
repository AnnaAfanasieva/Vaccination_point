package ua.com.alevel.vaccination_point.facade.item.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.item.NoteFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.NoteRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.NoteResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.item.NoteService;
import ua.com.alevel.vaccination_point.service.item.VaccineService;
import ua.com.alevel.vaccination_point.service.user.DoctorService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteFacadeImpl implements NoteFacade {

    private final NoteService noteService;
    private final DoctorService doctorService;
    private final VaccineService vaccineService;

    public NoteFacadeImpl(NoteService noteService, DoctorService doctorService, VaccineService vaccineService) {
        this.noteService = noteService;
        this.doctorService = doctorService;
        this.vaccineService = vaccineService;
    }

    @Override
    public void create(NoteRequestDto noteRequestDto) {
        Optional<Doctor> doctor = doctorService.findByIdAndVisible(noteRequestDto.getDoctorId(), true);
        Optional<Vaccine> vaccine = vaccineService.findByIdAndVisible(noteRequestDto.getVaccineId(), true);
        if (doctor.isPresent() && vaccine.isPresent()) {
            Note note = ConvertRequestDtoToEntity.createNoteEntity(noteRequestDto, new Note(), doctor.get(), vaccine.get());
            noteService.create(note);
        } else {
            throw new RuntimeException("Запис відсутній");
        }

    }

    @Override
    public void update(NoteRequestDto noteRequestDto, Long id) {
        Optional<Note> optionalNote = noteService.findById(id);
        Optional<Doctor> doctor = doctorService.findByIdAndVisible(noteRequestDto.getDoctorId(), true);
        Optional<Vaccine> vaccine = vaccineService.findByIdAndVisible(noteRequestDto.getVaccineId(), true);
        if (optionalNote.isPresent() && doctor.isPresent() && vaccine.isPresent()) {
            Note note = optionalNote.get();
            note.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createNoteEntity(noteRequestDto, note, doctor.get(), vaccine.get());
            noteService.update(note);
        } else {
            throw new RuntimeException("Запис відсутній");
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

    @Override
    public List<NoteResponseDto> findAllByVaccine(Vaccine vaccine) {
        List<NoteResponseDto> dtoList = new ArrayList<>();
        for (Note note : noteService.findAllByVaccine(vaccine)) {
            dtoList.add(new NoteResponseDto(note));
        }
        return dtoList;
    }

    @Override
    public NoteResponseDto findByIdAndVisible(Long id, boolean isVisible) {
        return new NoteResponseDto(noteService.findByIdAndVisible(id, isVisible).get());
    }

    @Override
    public List<NoteResponseDto> findAllByVisible(boolean isVisible) {
        //TODO переробити з використанням stream api
        List<NoteResponseDto> dtoList = new ArrayList<>();
        for (Note note : noteService.findAllByVisible(isVisible)) {
            dtoList.add(new NoteResponseDto(note));
        }
        return dtoList;
    }
}
