package ua.com.alevel.vaccination_point.model.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;
import ua.com.alevel.vaccination_point.model.util.RoleType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {

    @ManyToOne()
    private VaccinationPoint vaccinationPoint;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "doctor")
    private Set<Note> notes;

    public Doctor() {
        super();
        setRoleType(RoleType.ROLE_DOCTOR);
        this.notes = new HashSet<>();
    }

    public Doctor(User user) {
        super();
        setSurname(user.getSurname());
        setName(user.getName());
        setPatronymic(user.getPatronymic());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setRoleType(RoleType.ROLE_DOCTOR);
        this.notes = new HashSet<>();
    }
}
