package ua.com.alevel.vaccination_point.facade.util;

import ua.com.alevel.vaccination_point.model.dto.request.DoctorRequestDto;
import ua.com.alevel.vaccination_point.model.dto.request.NoteRequestDto;
import ua.com.alevel.vaccination_point.model.dto.request.VaccinationPointRequestDto;
import ua.com.alevel.vaccination_point.model.dto.request.VaccineRequestDto;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

public final class ConvertRequestDtoToEntity {

    private ConvertRequestDtoToEntity() {

    }

    public static Note createNoteEntity(NoteRequestDto dto, Note note) {
        note.setSurname(dto.getSurname());
        note.setName(dto.getName());
        note.setPatronymic(dto.getPatronymic());
        note.setPhone(dto.getPhone());
        note.setDateOfBirth(dto.getDateOfBirth());
        note.setVaccine(dto.getVaccine());
        note.setVaccineDate(dto.getVaccineDate());
        note.setDoctor(dto.getDoctor());
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

    public static Doctor createDoctorEntity(DoctorRequestDto dto, Doctor doctor) {
        doctor.setSurname(dto.getSurname());
        doctor.setName(dto.getName());
        doctor.setPatronymic(dto.getPatronymic());
        doctor.setVaccinationPoint(dto.getVaccinationPoint());
        doctor.setNotes(dto.getNotes());
        return doctor;
    }
}
