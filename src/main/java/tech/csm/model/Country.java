package tech.csm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "country")
public class Country implements Serializable {

	@Id
	@Column(name = "country_id")
	public Integer countryId;

	@Column(name = "country_name")
	public String countryName;

}
