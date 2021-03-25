package com.tyss.jpawithhibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="adhar_details")
public class AdharDetails {
	@Id
	@Column
private int aid;
	@Column
private String address;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "aadhar")
	private Persons person;
}
