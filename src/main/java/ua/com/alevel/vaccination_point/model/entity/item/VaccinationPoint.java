package ua.com.alevel.vaccination_point.model.entity.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.BaseEntity;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vaccination_points")
public class VaccinationPoint extends BaseEntity {

    private String address;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "vaccinationPoint")
    private Set<Doctor> doctors;

    public VaccinationPoint() {
        super();
        this.doctors = new HashSet<>();
    }
}
