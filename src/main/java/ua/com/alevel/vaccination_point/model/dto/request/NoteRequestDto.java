package ua.com.alevel.vaccination_point.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.Date;

@Getter
@Setter
@ToString
public class NoteRequestDto extends RequestDto {

    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private Date dateOfBirth;
    private Vaccine vaccine;
    private Date vaccineDate;
    private Doctor doctor;
}
