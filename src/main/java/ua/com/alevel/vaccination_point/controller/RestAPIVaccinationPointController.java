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

    //TODO find by id
    public String findByIdVaccinationPoint() {
        return null;
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
