package ua.com.alevel.vaccination_point.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;

import java.util.Set;

@Getter
@Setter
@ToString
public class DoctorRequestDto extends RequestDto {

    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String password;
    private Long vaccinationPointId;
    private Set<Note> notes;
}
