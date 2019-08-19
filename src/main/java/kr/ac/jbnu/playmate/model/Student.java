package kr.ac.jbnu.playmate.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
@Entity
@Table(name="student")
public class Student extends UserEntity{

	@ManyToOne
	@JoinColumn(name="class_Id")
	private Class myclass;

	
}
