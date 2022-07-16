package ua.com.alevel.vaccination_point.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.vaccination_point.facade.item.VaccineFacade;
import ua.com.alevel.vaccination_point.model.dto.request.VaccineRequestDto;

@RestController
@RequestMapping("/api/vaccine")
public class RestAPIVaccineController {

    private final VaccineFacade vaccineFacade;
    private final Gson gson = new Gson();

    public RestAPIVaccineController(VaccineFacade vaccineFacade) {
        this.vaccineFacade = vaccineFacade;
    }

    @GetMapping("/new")
    public void createVaccine(@RequestBody VaccineRequestDto dto) {
        vaccineFacade.create(dto);
    }

    //TODO update
    public void updateVaccine() {

    }

    @GetMapping("/delete/{id}")
    public void deleteVaccine (@PathVariable("id") Long id) {
        vaccineFacade.delete(id);
    }

    //TODO find by id
    public String findByIdVaccine() {
        return null;
    }

    @GetMapping("/all")
    public String findAllVaccines() {
        return gson.toJson(vaccineFacade.findAll());
    }

    @GetMapping("/all/visible")
    public String findAllVisibleVaccine() {
        return gson.toJson(vaccineFacade.findAllByVisible(true));
    }

    @GetMapping("/all/invisible")
    public String findAllInvisibleVaccine() {
        return gson.toJson(vaccineFacade.findAllByVisible(false));
    }
}
