package kr.ac.jbnu.playmate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class Class extends BaseEntity{
@Override
public String toString() {
	return "Class [studentGrade=" + studentGrade + ", classNumber=" + classNumber
			+ ", school=" + school + "]";
}

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
	
//	// 고유번호 
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="teacher_id")
//	private User classTeacher;
	
	//
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="school_id")
	private School school;

	public Integer getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(Integer studentGrade) {
		this.studentGrade = studentGrade;
	}

	public Integer getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}

//	public User getClassTeacher() {
//		return classTeacher;
//	}
//
//	public void setClassTeacher(User classTeacher) {
//		this.classTeacher = classTeacher;
//	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	/*
	 * private Schedule schedules;
	 * private List<Article> articles;
	 * etc..class functions will be added
	 * */
	
}
