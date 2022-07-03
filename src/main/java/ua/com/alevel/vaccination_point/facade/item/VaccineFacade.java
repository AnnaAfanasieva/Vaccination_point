package ua.com.alevel.vaccination_point.facade.item;

import ua.com.alevel.vaccination_point.facade.BaseFacade;
import ua.com.alevel.vaccination_point.model.dto.request.VaccineRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.VaccineResponseDto;

import java.util.List;

public interface VaccineFacade extends BaseFacade<VaccineRequestDto, VaccineResponseDto> {

    VaccineResponseDto findByIdAndVisible(Long id, boolean isVisible);

    List<VaccineResponseDto> findAllByVisible(boolean isVisible);
}
