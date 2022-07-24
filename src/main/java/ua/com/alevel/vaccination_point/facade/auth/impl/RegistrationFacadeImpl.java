package ua.com.alevel.vaccination_point.facade.auth.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.auth.RegistrationFacade;
import ua.com.alevel.vaccination_point.model.dto.request.AuthDto;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.model.entity.user.MainAdmin;
import ua.com.alevel.vaccination_point.model.entity.user.PointAdmin;
import ua.com.alevel.vaccination_point.model.entity.user.User;
import ua.com.alevel.vaccination_point.model.util.RoleType;
import ua.com.alevel.vaccination_point.service.item.VaccinationPointService;
import ua.com.alevel.vaccination_point.service.user.DoctorService;
import ua.com.alevel.vaccination_point.service.user.MainAdminService;
import ua.com.alevel.vaccination_point.service.user.PointAdminService;

import java.util.Optional;

@Service
public class RegistrationFacadeImpl implements RegistrationFacade {

    private final VaccinationPointService vaccinationPointService;
    private final MainAdminService mainAdminService;
    private final PointAdminService pointAdminService;
    private final DoctorService doctorService;

    public RegistrationFacadeImpl(VaccinationPointService vaccinationPointService,
                                  MainAdminService mainAdminService,
                                  PointAdminService pointAdminService,
                                  DoctorService doctorService) {
        this.vaccinationPointService = vaccinationPointService;
        this.mainAdminService = mainAdminService;
        this.pointAdminService = pointAdminService;
        this.doctorService = doctorService;
    }

    @Override
    public void registration(AuthDto dto) {
        User user = new User();
        user.setSurname(dto.getSurname());
        user.setName(dto.getName());
        user.setPatronymic(dto.getPatronymic());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        if (dto.getRoleType().equals(RoleType.ROLE_MAIN_ADMIN)) {
            createMainAdmin(user);
        } else if (dto.getRoleType().equals(RoleType.ROLE_POINT_ADMIN)) {
            createPointAdmin(user, dto.getVaccinationPointId());
        } else if (dto.getRoleType().equals(RoleType.ROLE_DOCTOR)) {
            createDoctor(user, dto.getVaccinationPointId());
        } else {
            throw new RuntimeException("Обраної ролі не існує");
        }
    }

    private void createMainAdmin(User user) {
        MainAdmin mainAdmin = new MainAdmin(user);
        mainAdminService.create(mainAdmin);
    }

    private void createPointAdmin(User user, Long vaccinationPointId) {
        PointAdmin pointAdmin = new PointAdmin(user);
        pointAdmin.setVaccinationPoint(createVaccinationPoint(vaccinationPointId));
        pointAdminService.create(pointAdmin);
    }

    private void createDoctor(User user, Long vaccinationPointId) {
        Doctor doctor = new Doctor(user);
        doctor.setVaccinationPoint(createVaccinationPoint(vaccinationPointId));
        doctorService.create(doctor);
    }

    private VaccinationPoint createVaccinationPoint(Long vaccinationPointId) {
        Optional<VaccinationPoint> vaccinationPoint = vaccinationPointService.findByIdAndVisible(vaccinationPointId, true);
        if (vaccinationPoint.isPresent()) {
            return vaccinationPoint.get();
        } else {
            throw new RuntimeException("Пункт вакцинації відсутній");

        }
    }
}
