package ua.com.alevel.vaccination_point.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.vaccination_point.config.util.SecurityUtil;

@Controller
@RequestMapping("/dashboard")
public class RedirectController {

    @GetMapping
    public String dashboard() {
        return SecurityUtil.redirectUserToDashboard();
    }
}
