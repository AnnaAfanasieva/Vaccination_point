package ua.com.alevel.vaccination_point.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.user.PointAdmin;

@Getter
@Setter
@ToString
public class PointAdminResponseDto extends ResponseDto {

    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private Long vaccinationPointId;

    public PointAdminResponseDto() {

    }

    public PointAdminResponseDto (PointAdmin pointAdmin) {
        setId(pointAdmin.getId());
        setCreated(pointAdmin.getCreated());
        setUpdated(pointAdmin.getUpdated());
        setVisible(pointAdmin.isVisible());
        this.surname = pointAdmin.getSurname();
        this.name = pointAdmin.getName();
        this.patronymic = pointAdmin.getPatronymic();
        this.email = pointAdmin.getEmail();
        this.vaccinationPointId = pointAdmin.getVaccinationPoint().getId();
    }
}
