package ua.com.alevel.vaccination_point.model.entity.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("POINT_ADMIN")
public class PointAdmin extends User {

    public PointAdmin() {
        super();
    }
}
