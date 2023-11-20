package tech.csm.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "state")
public class State implements Serializable {

    @Id
    @Column(name = "state_id")
    public Integer stateId;

    @Column(name = "state_name")
    public String stateName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country country;
}
