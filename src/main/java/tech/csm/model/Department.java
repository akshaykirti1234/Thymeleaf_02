package tech.csm.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @Column(name = "dept_id")
    public Integer deptId;

    @Column(name = "dept_name")
    public String deptName;

}
