package ua.com.alevel.vaccination_point.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VaccineRequestDto extends RequestDto {

    private String name;
}
