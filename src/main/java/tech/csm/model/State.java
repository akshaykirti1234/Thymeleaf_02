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
