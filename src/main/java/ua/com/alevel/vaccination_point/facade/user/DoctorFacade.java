package ua.com.alevel.vaccination_point.facade.user;

import ua.com.alevel.vaccination_point.facade.BaseFacade;
import ua.com.alevel.vaccination_point.model.dto.request.DoctorRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.DoctorResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;

import java.util.List;

public interface DoctorFacade extends BaseFacade<DoctorRequestDto, DoctorResponseDto> {

    List<DoctorResponseDto> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint);

    DoctorResponseDto findByIdAndVisible(Long id, boolean isVisible);

    List<DoctorResponseDto> findAllByVisible(boolean isVisible);

    List<DoctorResponseDto> findAllByVaccinationPointAndVisible(VaccinationPoint vaccinationPoint, boolean isVisible);
}
