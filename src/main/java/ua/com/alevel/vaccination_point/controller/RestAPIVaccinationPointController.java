package ua.com.alevel.vaccination_point.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.vaccination_point.facade.item.VaccinationPointFacade;
import ua.com.alevel.vaccination_point.model.dto.request.VaccinationPointRequestDto;

@RestController
@RequestMapping("/api/vaccination_point")
public class RestAPIVaccinationPointController {

    private final VaccinationPointFacade vaccinationPointFacade;
    private final Gson gson = new Gson();

    public RestAPIVaccinationPointController(VaccinationPointFacade vaccinationPointFacade) {
        this.vaccinationPointFacade = vaccinationPointFacade;
    }

    @GetMapping("/new")
    public void createVaccinationPoint(@RequestBody VaccinationPointRequestDto dto) {
        vaccinationPointFacade.create(dto);
    }

    //TODO update
    public void updateVaccinationPoint() {

    }

    @GetMapping("/delete/{id}")
    public void deleteVaccinationPoint(@PathVariable("id") Long id) {
        vaccinationPointFacade.delete(id);
    }

    @GetMapping("/details/{id}")
    public String findByIdVaccinationPoint(@PathVariable("id") Long id) {
        return gson.toJson(vaccinationPointFacade.findById(id));
    }

    @GetMapping("/details/visible/{id}")
    public String findByIdVisibleVaccinationPoint(@PathVariable("id") Long id) {
        return gson.toJson(vaccinationPointFacade.findByIdAndVisible(id, true));
    }

    @GetMapping("/details/invisible/{id}")
    public String findByIdInvisibleVaccinationPoint(@PathVariable("id") Long id) {
        return gson.toJson(vaccinationPointFacade.findByIdAndVisible(id, false));
    }

    @GetMapping("/all")
    public String findAllVaccinationPoint() {
        return gson.toJson(vaccinationPointFacade.findAll());
    }

    @GetMapping("/all/visible")
    public String findAllVisibleVaccinationPoint() {
        return gson.toJson(vaccinationPointFacade.findAllByVisible(true));
    }

    @GetMapping("/all/invisible")
    public String findAllInvisibleVaccinationPoint() {
        return gson.toJson(vaccinationPointFacade.findAllByVisible(false));
    }
}
