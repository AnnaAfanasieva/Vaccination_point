package ua.com.alevel.vaccination_point.service.util;

import ua.com.alevel.vaccination_point.dao.crud.CrudRepositoryHelper;
import ua.com.alevel.vaccination_point.dao.repository.item.NoteRepository;
import ua.com.alevel.vaccination_point.dao.repository.user.DoctorRepository;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.Set;

public final class CascadeDelete {

    private CascadeDelete() {

    }

    public static void deleteAllNotesByDoctor(Doctor doctor,
                                              CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelper,
                                              NoteRepository noteRepository) {
        Set<Note> notes = doctor.getNotes();
        for (Note note : notes) {
            crudRepositoryHelper.delete(noteRepository, note.getId());
        }
    }

    public static void deleteAllDoctorsAndNotesByVaccinationPoint(VaccinationPoint vaccinationPoint,
                                                                  CrudRepositoryHelper<Note, NoteRepository> crudRepositoryHelperNote,
                                                                  NoteRepository noteRepository,
                                                                  CrudRepositoryHelper<Doctor, DoctorRepository> crudRepositoryHelperDoctor,
                                                                  DoctorRepository doctorRepository) {
        Set<Doctor> doctors = vaccinationPoint.getDoctors();
        for (Doctor doctor : doctors) {
            if (doctor.getRoleType().name().equals("ROLE_DOCTOR")) {
                deleteAllNotesByDoctor(doctor, crudRepositoryHelperNote, noteRepository);
                crudRepositoryHelperDoctor.delete(doctorRepository, doctor.getId());
            }
        }


    }
}
