package com.tyss.jpawithhibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="person1_info")
public class Persons {
	@Id
	@Column
private int id;
	@Column
private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="aid")
	private AdharDetails aadhar;
}
