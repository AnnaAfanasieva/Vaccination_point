package ua.com.alevel.vaccination_point.dao.repository.item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccinationPointRepository extends BaseRepository<VaccinationPoint> {

    @Query ("select vp from VaccinationPoint vp where vp.id = :id and vp.isVisible = :isVisible")
    Optional<VaccinationPoint> findByIdAndVisible(Long id, boolean isVisible);

    @Query ("select vp from VaccinationPoint vp where vp.isVisible = :isVisible")
    List<VaccinationPoint> findAllByVisible(boolean isVisible);
}
