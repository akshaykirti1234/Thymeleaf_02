package tech.csm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

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
