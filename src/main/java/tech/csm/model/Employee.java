package tech.csm.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "tech.csm.util.CustomIdGenerator")
    @Column(name = "employee_id")
    public String empId;

    @Column(name = "employee_name")
    public String empName;

    @Column(name = "mobile")
    public String mobile;

    @Column(name = "email")
    public String email;

    @Column(name = "gender")
    public String gender;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public Date dob;

    @Column(name = "photo")
    public String photoPath;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    public Department department;

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country country;

    @ManyToOne
    @JoinColumn(name = "state_id")
    public State state;

    @ManyToOne
    @JoinColumn(name = "district_id")
    public District district;

    @Column(name = "isactive")
    public String isActive;


}
