package ua.com.alevel.vaccination_point.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.vaccination_point.facade.item.NoteFacade;
import ua.com.alevel.vaccination_point.facade.item.VaccinationPointFacade;
import ua.com.alevel.vaccination_point.facade.item.VaccineFacade;
import ua.com.alevel.vaccination_point.facade.user.DoctorFacade;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    private final NoteFacade noteFacade;
    private final VaccinationPointFacade vaccinationPointFacade;
    private final VaccineFacade vaccineFacade;
    private final DoctorFacade doctorFacade;
    private Gson gson = new Gson();

    public RestAPIController(NoteFacade noteFacade,
                             VaccinationPointFacade vaccinationPointFacade,
                             VaccineFacade vaccineFacade,
                             DoctorFacade doctorFacade) {
        this.noteFacade = noteFacade;
        this.vaccinationPointFacade = vaccinationPointFacade;
        this.vaccineFacade = vaccineFacade;
        this.doctorFacade = doctorFacade;
    }

    @GetMapping("/all/notes")
    public String findAllNotes() {
        return gson.toJson(noteFacade.findAll());
    }

    @GetMapping("/all/vaccinationPoints")
    public String findAllVaccinationPoints() {
        return gson.toJson(vaccinationPointFacade.findAll());
    }

    @GetMapping("/all/vaccines")
    public String findAllVaccines() {
        return gson.toJson(vaccineFacade.findAll());
    }

    @GetMapping("/all/doctors")
    public String findAllDoctors() {
        return gson.toJson(doctorFacade.findAll());
    }

    @DeleteMapping("/delete/note")
    public void deleteNote(@RequestParam(value = "id") Long noteId) {
        noteFacade.delete(noteId);
    }
}
