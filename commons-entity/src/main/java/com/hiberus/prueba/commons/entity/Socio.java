package com.hiberus.prueba.commons.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "socios")
public class Socio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String last_name;

	@NotEmpty
	private String address;

	@NotEmpty
	private String city;

	@NotEmpty
	@Email
	private String email;
	
	@Max(value = 3, message = "maximo de 3 slogan")
	@JsonIgnoreProperties(value= {"socio"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Slogan> sloganes;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Slogan> getSloganes() {
		return sloganes;
	}

	public void setSloganes(List<Slogan> sloganes) {
		this.sloganes = sloganes;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Socio)) {
			return false;
		}

		Socio a = (Socio) obj;

		return this.id != null && this.id.equals(a.getId());
	}

}
