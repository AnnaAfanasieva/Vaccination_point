package ua.com.alevel.vaccination_point.facade.user.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.vaccination_point.facade.user.DoctorFacade;
import ua.com.alevel.vaccination_point.facade.util.ConvertRequestDtoToEntity;
import ua.com.alevel.vaccination_point.model.dto.request.DoctorRequestDto;
import ua.com.alevel.vaccination_point.model.dto.response.DoctorResponseDto;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.service.user.DoctorService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorFacadeImpl implements DoctorFacade {

    private final DoctorService doctorService;

    public DoctorFacadeImpl(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public void create(DoctorRequestDto doctorRequestDto) {
        Doctor doctor = ConvertRequestDtoToEntity.createDoctorEntity(doctorRequestDto, new Doctor());
        doctorService.create(doctor);
    }

    @Override
    public void update(DoctorRequestDto doctorRequestDto, Long id) {
        Optional<Doctor> optionalDoctor = doctorService.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setUpdated(new Timestamp(System.currentTimeMillis()));
            ConvertRequestDtoToEntity.createDoctorEntity(doctorRequestDto, doctor);
            doctorService.update(doctor);
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
}
