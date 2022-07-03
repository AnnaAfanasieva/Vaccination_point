package ua.com.alevel.vaccination_point.facade.item.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.item.VaccineFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.VaccineRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.VaccineResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.service.item.VaccineService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineFacadeImpl implements VaccineFacade {

    private final VaccineService vaccineService;

    public VaccineFacadeImpl(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @Override
    public void create(VaccineRequestDto vaccineRequestDto) {
        Vaccine vaccine = ConvertRequestDtoToEntity.createVaccineEntity(vaccineRequestDto, new Vaccine());
        vaccineService.create(vaccine);
    }

    @Override
    public void update(VaccineRequestDto vaccineRequestDto, Long id) {
        Optional<Vaccine> optionalVaccine = vaccineService.findById(id);
        if (optionalVaccine.isPresent()) {
            Vaccine vaccine = optionalVaccine.get();
            vaccine.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createVaccineEntity(vaccineRequestDto, vaccine);
            vaccineService.update(vaccine);
        }
    }

    @Override
    public void delete(Long id) {
        vaccineService.delete(id);
    }

    @Override
    public VaccineResponseDto findById(Long id) {
        return new VaccineResponseDto(vaccineService.findById(id).get());
    }

    @Override
    public List<VaccineResponseDto> findAll() {
        //TODO переробити з використанням stream api
        List<VaccineResponseDto> dtoList = new ArrayList<>();
        for (Vaccine vaccine : vaccineService.findAll()) {
            dtoList.add(new VaccineResponseDto(vaccine));
        }
        return dtoList;
    }

    @Override
    public VaccineResponseDto findByIdAndVisible(Long id, boolean isVisible) {
        return new VaccineResponseDto(vaccineService.findByIdAndVisible(id, isVisible).get());
    }

    @Override
    public List<VaccineResponseDto> findAllByVisible(boolean isVisible) {
        //TODO переробити з використанням stream api
        List<VaccineResponseDto> dtoList = new ArrayList<>();
        for (Vaccine vaccine : vaccineService.findAllByVisible(isVisible)) {
            dtoList.add(new VaccineResponseDto(vaccine));
        }
        return dtoList;
    }
}
