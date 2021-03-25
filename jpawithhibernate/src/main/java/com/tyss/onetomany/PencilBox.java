package com.tyss.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="pencilbox_info")
public class PencilBox {
	@Id
	@Column
private int boxId;
	@Column
private String bname;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "box")
	private List<Pencils> pencils;
}
