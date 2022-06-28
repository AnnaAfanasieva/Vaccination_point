package ua.com.alevel.vaccination_point.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.Set;

@Getter
@Setter
@ToString
public class DoctorResponseDto extends ResponseDto {

    private String surname;
    private String name;
    private String patronymic;
    private VaccinationPoint vaccinationPoint;
    private Set<Note> notes;

    public DoctorResponseDto() {

    }

    public DoctorResponseDto(Doctor doctor) {
        setId(doctor.getId());
        setCreated(doctor.getCreated());
        setUpdated(doctor.getUpdated());
        setVisible(doctor.isVisible());
        this.surname = doctor.getSurname();
        this.name = doctor.getName();
        this.patronymic = doctor.getPatronymic();
        this.vaccinationPoint = doctor.getVaccinationPoint();
        this.notes = doctor.getNotes();
    }
}
