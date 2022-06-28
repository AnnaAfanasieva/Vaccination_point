package ua.com.alevel.vaccination_point.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.Set;

@Getter
@Setter
@ToString
public class VaccinationPointRequestDto extends RequestDto {

    private String address;
    private Set<Doctor> doctors;

}
