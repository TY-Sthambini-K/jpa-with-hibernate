package jpawithhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="movie_info")
public class Movie {
	@Id
	@Column(name="movie_id")
private int pid;
	@Column
private String name;
	@Column
private String review;
}
