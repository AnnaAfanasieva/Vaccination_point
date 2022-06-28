package ua.com.alevel.vaccination_point.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.Date;

@Getter
@Setter
@ToString
public class NoteResponseDto extends ResponseDto {

    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private Date dateOfBirth;
    private Vaccine vaccine;
    private Date vaccineDate;
    private Doctor doctor;

    public NoteResponseDto() {

    }

    public NoteResponseDto(Note note) {
        setId(note.getId());
        setCreated(note.getCreated());
        setUpdated(note.getUpdated());
        setVisible(note.isVisible());
        this.surname = note.getSurname();
        this.name = note.getName();
        this.patronymic = note.getPatronymic();
        this.phone = note.getPhone();
        this.dateOfBirth = note.getDateOfBirth();
        this.vaccine = note.getVaccine();
        this.vaccineDate = note.getVaccineDate();
        this.doctor = note.getDoctor();
    }
}
