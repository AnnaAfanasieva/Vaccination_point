package ua.com.alevel.vaccination_point.model.entity.user;

import ua.com.alevel.vaccination_point.model.util.RoleType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MAIN_ADMIN")
public class MainAdmin extends User {

    public MainAdmin() {
        super();
        setRoleType(RoleType.ROLE_MAIN_ADMIN);
    }

    public MainAdmin(User user) {
        super();
        setSurname(user.getSurname());
        setName(user.getName());
        setPatronymic(user.getPatronymic());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setRoleType(RoleType.ROLE_MAIN_ADMIN);
    }
}
