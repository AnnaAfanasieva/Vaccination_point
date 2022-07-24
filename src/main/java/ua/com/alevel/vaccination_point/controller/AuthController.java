package ua.com.alevel.vaccination_point.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

//import ua.com.alevel.facade.AuthValidatorFacade;
//import ua.com.alevel.facade.RegistrationFacade;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.alevel.vaccination_point.config.SecurityService;
import ua.com.alevel.vaccination_point.config.util.SecurityUtil;
import ua.com.alevel.vaccination_point.facade.auth.RegistrationFacade;
import ua.com.alevel.vaccination_point.facade.item.VaccinationPointFacade;
import ua.com.alevel.vaccination_point.model.dto.request.AuthDto;
import ua.com.alevel.vaccination_point.model.util.RoleType;

import java.util.EnumMap;
//import ua.com.alevel.web.dto.request.register.AuthDto;

@Controller
public class AuthController {

    private final RegistrationFacade registrationFacade;
//    private final AuthValidatorFacade authValidatorFacade;
    private final SecurityService securityService;
    private final EnumMap<RoleType, String> roles = new EnumMap<RoleType, String>(RoleType.class);
    private final VaccinationPointFacade vaccinationPointFacade;

    public AuthController(
            RegistrationFacade registrationFacade,
//            AuthValidatorFacade authValidatorFacade,
            SecurityService securityService, VaccinationPointFacade vaccinationPointFacade) {
        this.registrationFacade = registrationFacade;
//        this.authValidatorFacade = authValidatorFacade;
        this.securityService = securityService;
        this.vaccinationPointFacade = vaccinationPointFacade;
        this.roles.put(RoleType.ROLE_MAIN_ADMIN, "Головний адміністратор");
        this.roles.put(RoleType.ROLE_POINT_ADMIN, "Адміністратор пункту вакцинації");
        this.roles.put(RoleType.ROLE_DOCTOR, "Лікар");
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
//        showMessage(model, false);
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            return SecurityUtil.redirectUserToDashboard();
        }
        if (error != null) {
//            showError(model, "Your email and password is invalid.");
        }
        if (logout != null) {
//            showInfo(model, "You have been logged out successfully.");
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
//        if (securityService.isAuthenticated()) {
//            return redirectProcess(model);
//        }
        model.addAttribute("vaccinationPointList", vaccinationPointFacade.findAllByVisible(true));
        model.addAttribute("authForm", new AuthDto());
        model.addAttribute("roleTypes", roles);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("authForm") AuthDto authForm, BindingResult bindingResult, Model model) {
//        showMessage(model, false);
//        authValidatorFacade.validate(authForm, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
        registrationFacade.registration(authForm);
        securityService.autoLogin(authForm.getEmail(), authForm.getPassword());
        return redirectProcess(model);
    }

    private String redirectProcess(Model model) {
//        showMessage(model, false);
        return SecurityUtil.redirectUserToDashboard();
    }

    @GetMapping("/main_admin/dashboard")
    public String redirectMainAdmin() {
        return "test";
    }

    @GetMapping("/point_admin/dashboard")
    public String redirectPointAdmin(){
        return "test";
    }

    @GetMapping("/doctor/dashboard")
    public String redirectDoctor(){
        return "test";
    }
}
