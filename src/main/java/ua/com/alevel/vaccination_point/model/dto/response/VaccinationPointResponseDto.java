package ua.com.alevel.vaccination_point.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import java.util.Set;

@Getter
@Setter
public class VaccinationPointResponseDto extends ResponseDto {

    private String address;
//    private Set<Doctor> doctors;

    public VaccinationPointResponseDto() {

    }

    public VaccinationPointResponseDto(VaccinationPoint vaccinationPoint) {
        setId(vaccinationPoint.getId());
        setCreated(vaccinationPoint.getCreated());
        setUpdated(vaccinationPoint.getUpdated());
        setVisible(vaccinationPoint.isVisible());
        this.address = vaccinationPoint.getAddress();
//        this.doctors = vaccinationPoint.getDoctors();
    }
}
