package ua.com.alevel.vaccination_point.model.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;

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
    }
}
