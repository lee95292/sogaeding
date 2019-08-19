package kr.ac.jbnu.playmate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="teacher")
public class Teacher extends UserEntity{
	
	@OneToOne
	@JoinColumn(name="class_id")
	private Class myclass;

}
