package ua.com.alevel.vaccination_point.service.user;

import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService extends UserService<Doctor> {

    List<Doctor> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint);

    Optional<Doctor> findByIdAndVisible(Long id, boolean isVisible);

    List<Doctor> findAllByVisible(boolean isVisible);
//    DataTableResponse<Doctor> findAllByVaccinationPoint(DataTableRequest request, VaccinationPoint vaccinationPoint);

}
