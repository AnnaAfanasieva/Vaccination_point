package ua.com.alevel.vaccination_point.model.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.util.RoleType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("POINT_ADMIN")
public class PointAdmin extends User {

    @OneToOne
    private VaccinationPoint vaccinationPoint;

    public PointAdmin() {
        super();
        setRoleType(RoleType.ROLE_POINT_ADMIN);
    }

    public PointAdmin(User user) {
        super();
        setSurname(user.getSurname());
        setName(user.getName());
        setPatronymic(user.getPatronymic());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setRoleType(RoleType.ROLE_POINT_ADMIN);
    }
}
