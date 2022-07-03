package ua.com.alevel.vaccination_point.service.item;

import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface VaccinationPointService extends BaseService<VaccinationPoint> {

    Optional<VaccinationPoint> findByIdAndVisible(Long id, boolean isVisible);

    List<VaccinationPoint> findAllByVisible(boolean isVisible);
}
