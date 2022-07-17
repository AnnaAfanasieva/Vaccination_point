package ua.com.alevel.vaccination_point.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.vaccination_point.facade.item.NoteFacade;
import ua.com.alevel.vaccination_point.facade.item.VaccineFacade;
import ua.com.alevel.vaccination_point.model.dto.request.NoteRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.VaccineResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

@RestController
@RequestMapping("/api/note")
public class RestAPINoteController {

    private final NoteFacade noteFacade;
    private final VaccineFacade vaccineFacade;
    private final Gson gson = new Gson();

    public RestAPINoteController(NoteFacade noteFacade, VaccineFacade vaccineFacade) {
        this.noteFacade = noteFacade;
        this.vaccineFacade = vaccineFacade;
    }

    @GetMapping("/new")
    public void createNote(@RequestBody NoteRequestDto dto) {
        noteFacade.create(dto);
    }

    //TODO update
    public void updateNote() {

    }

    @GetMapping("/delete/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteFacade.delete(id);
    }

    @GetMapping("/details/{id}")
    public String findByIdNote(@PathVariable("id") Long id) {
        return gson.toJson(noteFacade.findById(id));
    }

    @GetMapping("/details/visible/{id}")
    public String findByIdVisibleNote(@PathVariable("id") Long id) {
        return gson.toJson(noteFacade.findByIdAndVisible(id, true));
    }

    @GetMapping("/details/invisible/{id}")
    public String findByIdInvisibleNote(@PathVariable("id") Long id) {
        return gson.toJson(noteFacade.findByIdAndVisible(id, false));
    }

    @GetMapping("/all")
    public String findAllNote() {
        return gson.toJson(noteFacade.findAll());
    }

    @GetMapping("/all/visible")
    public String findAllVisibleNote() {
        return gson.toJson(noteFacade.findAllByVisible(true));
    }

    @GetMapping("/all/invisible")
    public String findAllInvisibleNote() {
        return gson.toJson(noteFacade.findAllByVisible(false));
    }

    @GetMapping("/vaccine/{id}")
    public String findAllNotesByVaccine(@PathVariable("id") Long id) {
        VaccineResponseDto vaccineDto = vaccineFacade.findById(id);
        Vaccine vaccine = new Vaccine(vaccineDto);
        return gson.toJson(noteFacade.findAllByVaccine(vaccine));
    }
}
