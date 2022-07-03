package ua.com.alevel.vaccination_point.facade.item;

import ua.com.alevel.vaccination_point.facade.BaseFacade;
import ua.com.alevel.vaccination_point.model.dto.request.VaccinationPointRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.VaccinationPointResponseDto;

import java.util.List;

public interface VaccinationPointFacade extends BaseFacade<VaccinationPointRequestDto, VaccinationPointResponseDto> {

    VaccinationPointResponseDto findByIdAndVisible(Long id, boolean isVisible);

    List<VaccinationPointResponseDto> findAllByVisible(boolean isVisible);
}
