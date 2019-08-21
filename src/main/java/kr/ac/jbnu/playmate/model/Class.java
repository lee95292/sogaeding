package kr.ac.jbnu.playmate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="class")
public class Class extends BaseEntity{
//	
//	@Column(name="class_name")
//	private String className;
//	
	// 학년 
	@Column(name="studnet_grade")
	private Integer studentGrade;
	
	// 반 
	@Column(name="class_number")
	private Integer classNumber;
	
	// 고유번호 
	@OneToOne
	@JoinColumn(name="teacher_id")
	private User classTeacher;
	
	//
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	
	/*
	 * private Schedule schedules;
	 * private List<Article> articles;
	 * etc..class functions will be added
	 * */
}
