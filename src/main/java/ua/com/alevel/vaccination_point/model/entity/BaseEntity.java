package ua.com.alevel.vaccination_point.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    private boolean isVisible;

    public BaseEntity() {
        this.created = new Date();
        this.updated = new Date();
        this.isVisible = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = new Date();
    }
}
