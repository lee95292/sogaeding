package kr.ac.jbnu.playmate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="student")
public class Student extends UserEntity{

	@ManyToOne
	@JoinColumn(name="class_Id")
	private Class myclass;
	
}
