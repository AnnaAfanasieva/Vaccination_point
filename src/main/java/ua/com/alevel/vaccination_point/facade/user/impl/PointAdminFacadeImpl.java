package ua.com.alevel.vaccination_point.facade.user.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.user.PointAdminFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.PointAdminRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.PointAdminResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.PointAdmin;
import ua.com.alevel.vaccination_point.service.item.VaccinationPointService;
import ua.com.alevel.vaccination_point.service.user.PointAdminService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PointAdminFacadeImpl implements PointAdminFacade {

    private final PointAdminService pointAdminService;
    private final VaccinationPointService vaccinationPointService;

    public PointAdminFacadeImpl(PointAdminService pointAdminService, VaccinationPointService vaccinationPointService) {
        this.pointAdminService = pointAdminService;
        this.vaccinationPointService = vaccinationPointService;
    }

    @Override
    public void create(PointAdminRequestDto pointAdminRequestDto) {
        Optional<VaccinationPoint> vaccinationPoint = vaccinationPointService.findByIdAndVisible(pointAdminRequestDto.getVaccinationPointId(), true);
        if (vaccinationPoint.isPresent()) {
            PointAdmin pointAdmin = ConvertRequestDtoToEntity.createPointAdminEntity(
                    pointAdminRequestDto, new PointAdmin(), vaccinationPoint.get());
            pointAdminService.create(pointAdmin);
        } else {
            throw new RuntimeException("Пункт вакцинації відсутній");
        }
    }

    @Override
    public void update(PointAdminRequestDto pointAdminRequestDto, Long id) {
        Optional<VaccinationPoint> vaccinationPoint = vaccinationPointService
                .findByIdAndVisible(pointAdminRequestDto.getVaccinationPointId(), true);
        Optional<PointAdmin> optionalPointAdmin = pointAdminService.findById(id);
        if (vaccinationPoint.isPresent() && optionalPointAdmin.isPresent()) {
            PointAdmin pointAdmin = optionalPointAdmin.get();
            pointAdmin.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createPointAdminEntity(pointAdminRequestDto, pointAdmin, vaccinationPoint.get());
            pointAdminService.update(pointAdmin);
        } else {
            throw new RuntimeException("Пункт вакцинації відсутній");
        }
    }

    @Override
    public void delete(Long id) {
        pointAdminService.delete(id);
    }

    @Override
    public PointAdminResponseDto findById(Long id) {
        return new PointAdminResponseDto(pointAdminService.findById(id).get());
    }

    @Override
    public List<PointAdminResponseDto> findAll() {
        List<PointAdminResponseDto> dtoList = new ArrayList<>();
        for (PointAdmin pointAdmin : pointAdminService.findAll()) {
            dtoList.add(new PointAdminResponseDto(pointAdmin));
        }
        return dtoList;
    }
}
