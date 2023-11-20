package tech.csm.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "district")
public class District implements Serializable {

    @Id
    @Column(name = "district_id")
    public Integer districtId;

    @Column(name = "district_name")
    public String districtName;

    @ManyToOne
    @JoinColumn(name = "state_id")
    public State state;

}
