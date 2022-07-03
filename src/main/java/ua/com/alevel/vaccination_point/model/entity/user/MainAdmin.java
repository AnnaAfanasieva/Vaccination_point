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
}
