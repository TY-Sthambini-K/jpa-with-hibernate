package com.tyss.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "course_info")
public class CourseInfo {
	@Id
	@Column
	private int cid;
	@Column
	private String cname;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "course")
//	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "cid"))
private List<Students> students;
}
