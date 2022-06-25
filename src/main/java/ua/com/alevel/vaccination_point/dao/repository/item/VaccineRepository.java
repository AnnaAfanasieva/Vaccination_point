package ua.com.alevel.vaccination_point.dao.repository.item;

import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

@Repository
public interface VaccineRepository extends BaseRepository<Vaccine> {
}
