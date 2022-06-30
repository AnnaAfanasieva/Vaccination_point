package ua.com.alevel.vaccination_point.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.Vaccine;

@Getter
@Setter
public class VaccineResponseDto extends ResponseDto {

    private String name;

    public VaccineResponseDto() {

    }

    public VaccineResponseDto(Vaccine vaccine) {
        setId(vaccine.getId());
        setCreated(vaccine.getCreated());
        setUpdated(vaccine.getUpdated());
        setVisible(vaccine.isVisible());
        this.name = vaccine.getName();
    }
}
