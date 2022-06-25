package ua.com.alevel.vaccination_point.model.entity.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.vaccination_point.model.entity.BaseEntity;
import ua.com.alevel.vaccination_point.model.entity.user.Doctor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Note extends BaseEntity {

    private String surname;
    private String name;
    private String patronymic;
    private String phone;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @ManyToOne
    private Vaccine vaccine;

    @Column(name = "vaccine_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vaccineDate;

    @ManyToOne
    private Doctor doctor;

//    @ManyToOne()
//    @JoinColumn(name = "record_time_id", referencedColumnName = "id")
//    private RecordTime recordTime;

    public Note() {
        super();
    }
}
