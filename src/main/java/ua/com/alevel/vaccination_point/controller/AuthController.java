package ua.com.alevel.vaccination_point.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import ua.com.alevel.facade.AuthValidatorFacade;
//import ua.com.alevel.facade.RegistrationFacade;
import ua.com.alevel.vaccination_point.config.SecurityService;
import ua.com.alevel.vaccination_point.config.util.SecurityUtil;
import ua.com.alevel.vaccination_point.model.dto.request.AuthDto;
import ua.com.alevel.vaccination_point.model.util.RoleType;

import java.util.EnumMap;
import java.util.Map;
//import ua.com.alevel.web.dto.request.register.AuthDto;

@Controller
public class AuthController {

//    private final RegistrationFacade registrationFacade;
//    private final AuthValidatorFacade authValidatorFacade;
    private final SecurityService securityService;
    private final EnumMap<RoleType, String> roles = new EnumMap<RoleType, String>(RoleType.class);

    public AuthController(
//            RegistrationFacade registrationFacade,
//            AuthValidatorFacade authValidatorFacade,
            SecurityService securityService) {
//        this.registrationFacade = registrationFacade;
//        this.authValidatorFacade = authValidatorFacade;
        this.securityService = securityService;
        this.roles.put(RoleType.ROLE_MAIN_ADMIN, "Головний адміністратор");
        this.roles.put(RoleType.ROLE_POINT_ADMIN, "Адміністратор пункту вакцинації");
        this.roles.put(RoleType.ROLE_DOCTOR, "Лікар");
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
//        showMessage(model, false);
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            if (SecurityUtil.hasRole(RoleType.ROLE_MAIN_ADMIN.name())) {
                return "redirect:/admin/dashboard";
            }
            if (SecurityUtil.hasRole(RoleType.ROLE_POINT_ADMIN.name())) {
                return "redirect:/personal/dashboard";
            }
            if (SecurityUtil.hasRole(RoleType.ROLE_DOCTOR.name())) {
                return "redirect:/personal/dashboard";
            }
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
        model.addAttribute("authForm", new AuthDto());
        model.addAttribute("roleTypes", roles);
        return "registration";
    }
//
//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("authForm") AuthDto authForm, BindingResult bindingResult, Model model) {
//        showMessage(model, false);
//        authValidatorFacade.validate(authForm, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//        registrationFacade.registration(authForm);
//        securityService.autoLogin(authForm.getEmail(), authForm.getPasswordConfirm());
//        return redirectProcess(model);
//    }

//    private String redirectProcess(Model model) {
//        showMessage(model, false);
//        if (SecurityUtil.hasRole(RoleType.ROLE_MAIN_ADMIN.name())) {
//            return "redirect:/admin/dashboard";
//        }
//        if (SecurityUtil.hasRole(RoleType.ROLE_PERSONAL.name())) {
//            return "redirect:/personal/dashboard";
//        }
//        return "redirect:/login";
//    }
}