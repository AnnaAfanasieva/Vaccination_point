package ua.com.alevel.vaccination_point.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.user.MainAdmin;

@Getter
@Setter
@ToString
public class MainAdminResponseDto extends ResponseDto {

    private String surname;
    private String name;
    private String patronymic;
    private String email;

    public MainAdminResponseDto(){

    }

    public MainAdminResponseDto (MainAdmin mainAdmin) {
        setId(mainAdmin.getId());
        setCreated(mainAdmin.getCreated());
        setUpdated(mainAdmin.getUpdated());
        setVisible(mainAdmin.isVisible());
        this.surname = mainAdmin.getSurname();
        this.name = mainAdmin.getName();
        this.patronymic = mainAdmin.getPatronymic();
        this.email = mainAdmin.getEmail();
    }
}
