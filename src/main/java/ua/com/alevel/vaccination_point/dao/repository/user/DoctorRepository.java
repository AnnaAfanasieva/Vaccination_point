package ua.com.alevel.vaccination_point.dao.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends UserRepository<Doctor> {

    List<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint);

    @Query("select d from Doctor d where d.id = :id and d.isVisible = :isVisible")
    Optional<Doctor> findByIdAndVisible(Long id, boolean isVisible);

    @Query("select d from Doctor d where d.isVisible = :isVisible")
    List<Doctor> findAllByVisible(boolean isVisible);

//    Page<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint, Pageable pageable);
//
//    @Query("")
//    List<Doctor> findAllByName(String name);
}
