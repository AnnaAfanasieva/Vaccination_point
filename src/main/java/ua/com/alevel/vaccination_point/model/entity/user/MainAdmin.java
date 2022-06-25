package ua.com.alevel.vaccination_point.model.entity.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MAIN_ADMIN")
public class MainAdmin extends User {

    public MainAdmin() {
        super();
    }
}
