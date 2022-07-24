package ua.com.alevel.vaccination_point.facade.auth;

import ua.com.alevel.vaccination_point.model.dto.request.AuthDto;

public interface RegistrationFacade {

    void registration(AuthDto dto);
}
