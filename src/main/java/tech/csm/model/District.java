package tech.csm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

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
