package ua.com.alevel.vaccination_point.facade.item.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.item.VaccinationPointFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.VaccinationPointRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.VaccinationPointResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.service.item.VaccinationPointService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationPointFacadeImpl implements VaccinationPointFacade {

    private final VaccinationPointService vaccinationPointService;

    public VaccinationPointFacadeImpl(VaccinationPointService vaccinationPointService) {
        this.vaccinationPointService = vaccinationPointService;
    }

    @Override
    public void create(VaccinationPointRequestDto vaccinationPointRequestDto) {
        VaccinationPoint vaccinationPoint = ConvertRequestDtoToEntity.createVaccinationPointEntity(vaccinationPointRequestDto, new VaccinationPoint());
        vaccinationPointService.create(vaccinationPoint);
    }

    @Override
    public void update(VaccinationPointRequestDto vaccinationPointRequestDto, Long id) {
        Optional<VaccinationPoint> optionalVaccinationPoint = vaccinationPointService.findById(id);
        if (optionalVaccinationPoint.isPresent()) {
            VaccinationPoint vaccinationPoint = optionalVaccinationPoint.get();
            vaccinationPoint.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createVaccinationPointEntity(vaccinationPointRequestDto, vaccinationPoint);
            vaccinationPointService.update(vaccinationPoint);
        }
    }

    @Override
    public void delete(Long id) {
        vaccinationPointService.delete(id);
    }

    @Override
    public VaccinationPointResponseDto findById(Long id) {
        return new VaccinationPointResponseDto(vaccinationPointService.findById(id).get());
    }

    @Override
    public List<VaccinationPointResponseDto> findAll() {
        //TODO переробити з використанням stream api
        List<VaccinationPointResponseDto> dtoList = new ArrayList<>();
        for (VaccinationPoint vaccinationPoint : vaccinationPointService.findAll()) {
            dtoList.add(new VaccinationPointResponseDto(vaccinationPoint));
        }
        return dtoList;
    }
}
