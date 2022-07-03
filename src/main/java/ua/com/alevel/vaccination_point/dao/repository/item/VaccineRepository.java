package ua.com.alevel.vaccination_point.dao.repository.item;

import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends BaseRepository<Vaccine> {

    Optional<Vaccine> findByIdAndVisible(Long id, boolean isVisible);

    List<Vaccine> findAllByVisible(boolean isVisible);
}
