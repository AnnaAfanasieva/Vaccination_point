package ua.com.alevel.vaccination_point.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
public abstract class ResponseDto {

    private Long id;
    private Date created;
    private Date updated;
    private boolean isVisible;
}
