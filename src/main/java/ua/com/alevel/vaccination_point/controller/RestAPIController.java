package ua.com.alevel.vaccination_point.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.vaccination_point.facade.item.NoteFacade;
import ua.com.alevel.vaccination_point.facade.item.VaccinationPointFacade;
import ua.com.alevel.vaccination_point.facade.item.VaccineFacade;
import ua.com.alevel.vaccination_point.facade.user.DoctorFacade;
import ua.com.alevel.vaccination_point.model.dto.request.VaccinationPointRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.VaccineResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    private final NoteFacade noteFacade;
    private final VaccinationPointFacade vaccinationPointFacade;
    private final VaccineFacade vaccineFacade;
    private final DoctorFacade doctorFacade;
    private final Gson gson = new Gson();

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

    @GetMapping("/delete/note/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        noteFacade.delete(id);
    }

    @GetMapping("/delete/vaccinationPoint/{id}")
    public void deleteVaccinationPoint (@PathVariable("id") Long id) {
        vaccinationPointFacade.delete(id);
    }

    @GetMapping("/delete/vaccine/{id}")
    public void deleteVaccine (@PathVariable("id") Long id) {
        vaccineFacade.delete(id);
    }

    @GetMapping("/delete/doctor/{id}")
    public void deleteDoctor(@PathVariable("id") Long id) {
        doctorFacade.delete(id);
    }

    @GetMapping("/notes/vaccine/{id}")
    public String findAllNotesByVaccine(@PathVariable("id") Long id) {
        VaccineResponseDto vaccineDto = vaccineFacade.findById(id);
        Vaccine vaccine = new Vaccine(vaccineDto);
        return gson.toJson(noteFacade.findAllByVaccine(vaccine));
    }

    @GetMapping("/all/visible/vaccines")
    public String findAllVisibleVaccine() {
        return gson.toJson(vaccineFacade.findAllByVisible(true));
    }

    @PostMapping("/new/vaccinationPoint")
    public void createVaccinationPoint(@RequestBody VaccinationPointRequestDto dto) {
        vaccinationPointFacade.create(dto);
    }
}
