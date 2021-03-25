package com.tyss.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="pencils_info")
public class Pencils {
	@Id
	@Column
private int pid;
	@Column
private String color;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="boxId")
	private PencilBox box;
}
