package ua.com.alevel.vaccination_point.model.entity.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.dto.response.VaccineResponseDto;
import ua.com.alevel.vaccination_point.model.entity.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity
public class Vaccine extends BaseEntity {

    private String name;

    public Vaccine() {
        super();
    }

    public Vaccine (VaccineResponseDto dto) {
        setId(dto.getId());
        setCreated(dto.getCreated());
        setUpdated(dto.getUpdated());
        setVisible(dto.isVisible());
        this.name = dto.getName();
    }
}
