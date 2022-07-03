package ua.com.alevel.vaccination_point.dao.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends UserRepository<Doctor> {

    List<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint);

    Optional<Doctor> findByIdAndVisible(Long id, boolean isVisible);

    List<Doctor> findAllByVisible(boolean isVisible);

//    Page<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint, Pageable pageable);
//    List<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint);
//
//    @Query("")
//    List<Doctor> findAllByName(String name);
}
