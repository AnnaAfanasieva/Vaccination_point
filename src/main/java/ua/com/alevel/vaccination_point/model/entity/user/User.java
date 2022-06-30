package ua.com.alevel.vaccination_point.model.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
@Entity
public class User extends BaseEntity {

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private Boolean enabled;

    //TODO roleType need or not?
//    @Enumerated(EnumType.STRING)
//    @Column(name = "role_type", nullable = false)
//    private RoleType roleType;

    public User() {
        super();
        this.enabled = true;
    }
}
