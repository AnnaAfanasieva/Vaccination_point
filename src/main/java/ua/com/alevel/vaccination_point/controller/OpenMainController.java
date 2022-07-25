package ua.com.alevel.vaccination_point.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.vaccination_point.facade.item.VaccinationPointFacade;
import ua.com.alevel.vaccination_point.facade.item.VaccineFacade;
import ua.com.alevel.vaccination_point.facade.user.DoctorFacade;
import ua.com.alevel.vaccination_point.model.dto.request.NoteRequestDto;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;

@Controller
@RequestMapping("/open")
public class OpenMainController {

    private final VaccineFacade vaccineFacade;
    private final VaccinationPointFacade vaccinationPointFacade;
    private final DoctorFacade doctorFacade;

    public OpenMainController(VaccineFacade vaccineFacade,
                              VaccinationPointFacade vaccinationPointFacade,
                              DoctorFacade doctorFacade) {
        this.vaccineFacade = vaccineFacade;
        this.vaccinationPointFacade = vaccinationPointFacade;
        this.doctorFacade = doctorFacade;
    }

    //TODO date - колір м'якше і точна дата (формат)
    //TODO список лікарів підтягувати і позбутись проблеми
    @GetMapping
    public String personalInformationForm(Model model) {
        model.addAttribute("note", new NoteRequestDto());
        model.addAttribute("vaccineList",
                vaccineFacade.findAllByVisible(true));
        model.addAttribute("vaccinationPointList",
                vaccinationPointFacade.findAllByVisible(true));
        try {
            VaccinationPoint vaccinationPoint =
                    (VaccinationPoint) model.getAttribute("vaccinationPoint");
            model.addAttribute("doctorList",
                    doctorFacade.findAllByVaccinationPointAndVisible(vaccinationPoint, true));
        } catch (RuntimeException ignored) {
            System.out.println("У нас проблема!");
        }

        return "open/personal_information_form";
    }
}
