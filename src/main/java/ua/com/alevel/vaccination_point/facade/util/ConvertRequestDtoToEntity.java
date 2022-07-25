package ua.com.alevel.vaccination_point.facade.util;

import ua.com.alevel.vaccination_point.model.dto.request.*;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;
import ua.com.alevel.vaccination_point.model.entity.user.MainAdmin;
import ua.com.alevel.vaccination_point.model.entity.user.PointAdmin;
import ua.com.alevel.vaccination_point.model.entity.user.User;

public final class ConvertRequestDtoToEntity {

    private ConvertRequestDtoToEntity() {

    }

    public static Note createNoteEntity(NoteRequestDto dto, Note note, Doctor doctor, Vaccine vaccine) {
        note.setSurname(dto.getSurname());
        note.setName(dto.getName());
        note.setPatronymic(dto.getPatronymic());
        note.setPhone(dto.getPhone());
        note.setDateOfBirth(dto.getDateOfBirth());
        note.setVaccine(vaccine);
        note.setVaccineDate(dto.getVaccineDate());
        note.setDoctor(doctor);
        return note;
    }

    public static VaccinationPoint createVaccinationPointEntity(VaccinationPointRequestDto dto, VaccinationPoint vaccinationPoint) {
        vaccinationPoint.setAddress(dto.getAddress());
        vaccinationPoint.setDoctors(dto.getDoctors());
        return vaccinationPoint;
    }

    public static Vaccine createVaccineEntity(VaccineRequestDto dto, Vaccine vaccine) {
        vaccine.setName(dto.getName());
        return vaccine;
    }

    public static Doctor createDoctorEntity(DoctorRequestDto dto, Doctor doctor, VaccinationPoint vaccinationPoint) {
        doctor.setSurname(dto.getSurname());
        doctor.setName(dto.getName());
        doctor.setPatronymic(dto.getPatronymic());
        doctor.setEmail(dto.getEmail());
        doctor.setPassword(dto.getPassword());
        doctor.setVaccinationPoint(vaccinationPoint);
        doctor.setNotes(dto.getNotes());
        return doctor;
    }

    public static MainAdmin createMainAdminEntity(MainAdminRequestDto dto, MainAdmin mainAdmin) {
        mainAdmin.setSurname(dto.getSurname());
        mainAdmin.setName(dto.getName());
        mainAdmin.setPatronymic(dto.getPatronymic());
        mainAdmin.setRoleType(dto.getRoleType());
        mainAdmin.setEmail(dto.getEmail());
        mainAdmin.setPassword(dto.getPassword());
        return mainAdmin;
    }

    public static PointAdmin createPointAdminEntity(PointAdminRequestDto dto,
                                                    PointAdmin pointAdmin,
                                                    VaccinationPoint vaccinationPoint) {
        pointAdmin.setSurname(dto.getSurname());
        pointAdmin.setName(dto.getName());
        pointAdmin.setPatronymic(dto.getPatronymic());
        pointAdmin.setRoleType(dto.getRoleType());
        pointAdmin.setEmail(dto.getEmail());
        pointAdmin.setPassword(dto.getPassword());
        pointAdmin.setVaccinationPoint(vaccinationPoint);
        return pointAdmin;
    }
}
