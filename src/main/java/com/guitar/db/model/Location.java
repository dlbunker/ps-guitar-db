package com.guitar.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String state;
	private String country;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="LOCATION_ID")
	private List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(List<Manufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	public Long getId() {
		return id;
	}

}
