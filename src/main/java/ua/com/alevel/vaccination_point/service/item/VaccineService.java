package ua.com.alevel.vaccination_point.service.item;

import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface VaccineService extends BaseService<Vaccine> {

    Optional<Vaccine> findByIdAndVisible(Long id, boolean isVisible);

    List<Vaccine> findAllByVisible(boolean isVisible);
}
