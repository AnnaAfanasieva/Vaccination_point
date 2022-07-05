package ua.com.alevel.vaccination_point.dao.repository.item;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends BaseRepository<Vaccine> {

    @Query("select v from Vaccine v where v.id = :id and v.isVisible = :isVisible")
    Optional<Vaccine> findByIdAndVisible(Long id, boolean isVisible);

    @Query ("select v from Vaccine v where v.isVisible = :isVisible")
    List<Vaccine> findAllByVisible(boolean isVisible);
}
