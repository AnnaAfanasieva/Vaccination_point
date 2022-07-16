package ua.com.alevel.vaccination_point.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.vaccination_point.facade.user.DoctorFacade;
import ua.com.alevel.vaccination_point.model.dto.request.DoctorRequestDto;

@RestController
@RequestMapping("/api/doctor")
public class RestAPIDoctorController {

    private final DoctorFacade doctorFacade;
    private final Gson gson = new Gson();

    public RestAPIDoctorController(DoctorFacade doctorFacade) {
        this.doctorFacade = doctorFacade;
    }

    @GetMapping("/new")
    public void createDoctor(@RequestBody DoctorRequestDto dto) {
        doctorFacade.create(dto);
    }

    //TODO update
    public void updateDoctor() {

    }

    @GetMapping("/delete/{id}")
    public void deleteDoctor(@PathVariable("id") Long id) {
        doctorFacade.delete(id);
    }

    //TODO find by id
    public String findByIdDoctor() {
        return null;
    }

    @GetMapping("/all")
    public String findAllDoctors() {
        return gson.toJson(doctorFacade.findAll());
    }

    @GetMapping("/all/visible")
    public String findAllVisibleDoctor() {
        return gson.toJson(doctorFacade.findAllByVisible(true));
    }

    @GetMapping("/all/invisible")
    public String findAllInvisibleDoctor() {
        return gson.toJson(doctorFacade.findAllByVisible(false));
    }
}
