package ua.com.alevel.vaccination_point.model.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.item.Note;
import ua.com.alevel.vaccination_point.model.entity.item.VaccinationPoint;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {

    private String surname;
    private String name;
    private String patronymic;

    @ManyToOne()
    private VaccinationPoint vaccinationPoint;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "doctor")
    private Set<Note> notes;

    public Doctor() {
        super();
        this.notes = new HashSet<>();
    }
}
