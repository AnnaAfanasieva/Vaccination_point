package ua.com.alevel.vaccination_point.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.util.RoleType;

@Getter
@Setter
@ToString
public class MainAdminRequestDto extends RequestDto {

    private String surname;
    private String name;
    private String patronymic;
    private RoleType roleType;
    private String email;
    private String password;
}
