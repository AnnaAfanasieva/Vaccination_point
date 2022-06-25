package ua.com.alevel.vaccination_point.dao.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends UserRepository<Doctor>{

//    Page<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint, Pageable pageable);
//    List<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint);
//
//    @Query("")
//    List<Doctor> findAllByName(String name);
}
