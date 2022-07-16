package ua.com.alevel.vaccination_point.facade.user.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.user.DoctorFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.DoctorRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.DoctorResponseDto;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.item.VaccinationPointService;
import ua.com.alevel.vaccination_point.service.user.DoctorService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorFacadeImpl implements DoctorFacade {

    private final DoctorService doctorService;
    private final VaccinationPointService vaccinationPointService;
    private final BCryptPasswordEncoder encoder;

    public DoctorFacadeImpl(DoctorService doctorService, VaccinationPointService vaccinationPointService, BCryptPasswordEncoder encoder) {
        this.doctorService = doctorService;
        this.vaccinationPointService = vaccinationPointService;
        this.encoder = encoder;
    }

    @Override
    public void create(DoctorRequestDto doctorRequestDto) {
        Optional<VaccinationPoint> vaccinationPoint = vaccinationPointService.findByIdAndVisible(doctorRequestDto.getVaccinationPointId(), true);
        if (vaccinationPoint.isPresent()) {
            Doctor doctor = ConvertRequestDtoToEntity.createDoctorEntity(doctorRequestDto, new Doctor(), vaccinationPoint.get());
            doctor.setPassword(encoder.encode(doctor.getPassword()));
            doctorService.create(doctor);
        } else {
            throw new RuntimeException("Пункт вакцинації відсутній");
        }
    }

    @Override
    public void update(DoctorRequestDto doctorRequestDto, Long id) {
        Optional<Doctor> optionalDoctor = doctorService.findById(id);
        Optional<VaccinationPoint> vaccinationPoint = vaccinationPointService.findByIdAndVisible(doctorRequestDto.getVaccinationPointId(), true);
        if (optionalDoctor.isPresent() && vaccinationPoint.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createDoctorEntity(doctorRequestDto, doctor, vaccinationPoint.get());
            doctorService.update(doctor);
        } else {
            throw new RuntimeException("Запис відсутній");
        }
    }

    @Override
    public void delete(Long id) {
        doctorService.delete(id);
    }

    @Override
    public DoctorResponseDto findById(Long id) {
        return new DoctorResponseDto(doctorService.findById(id).get());
    }

    @Override
    public List<DoctorResponseDto> findAll() {
        //TODO переробити з використанням stream api
        List<DoctorResponseDto> dtoList = new ArrayList<>();
        for (Doctor doctor : doctorService.findAll()) {
            dtoList.add(new DoctorResponseDto(doctor));
        }
        return dtoList;
    }

    @Override
    public List<DoctorResponseDto> findAllByVaccinationPoint(VaccinationPoint vaccinationPoint) {
        List<DoctorResponseDto> dtoList = new ArrayList<>();
        for (Doctor doctor : doctorService.findAllByVaccinationPoint(vaccinationPoint)) {
            dtoList.add(new DoctorResponseDto(doctor));
        }
        return dtoList;
    }

    @Override
    public DoctorResponseDto findByIdAndVisible(Long id, boolean isVisible) {
        return new DoctorResponseDto(doctorService.findByIdAndVisible(id, isVisible).get());
    }

    @Override
    public List<DoctorResponseDto> findAllByVisible(boolean isVisible) {
        //TODO переробити з використанням stream api
        List<DoctorResponseDto> dtoList = new ArrayList<>();
        for (Doctor doctor : doctorService.findAllByVisible(isVisible)) {
            dtoList.add(new DoctorResponseDto(doctor));
        }
        return dtoList;
    }
}
