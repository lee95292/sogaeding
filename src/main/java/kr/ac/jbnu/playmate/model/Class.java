package kr.ac.jbnu.playmate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="class")
public class Class extends BaseEntity{
	
	@Column(name="class_name")
	private String className;
	
	@Column(name="studnet_grade")
	private Integer studentGrade;
	
	@Column(name="class_number")
	private Integer classNumber;
	
	@Column(name="class_teacher")
	private Teacher classTeacher;
	
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	
	/*
	 * private Schedule schedules;
	 * private List<Article> articles;
	 * etc..class functions will be added
	 * */
}
