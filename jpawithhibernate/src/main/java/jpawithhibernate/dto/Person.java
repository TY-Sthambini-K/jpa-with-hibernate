package jpawithhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persons_info")
public class Person {
	@Id
	@Column(name="id")
private int pid;
	@Column
private String name;
	@Column
private int salary;
public int getId() {
	return pid;
}
public void setId(int id) {
	this.pid = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}

}
