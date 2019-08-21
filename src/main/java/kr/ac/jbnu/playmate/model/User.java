package kr.ac.jbnu.playmate.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="user")
public class User extends BaseEntity{
	
	@Column(name="user_email")
	@NotNull
	private String userEmail;
	
	@Column (name="user_name")
	@NotNull
	private String userName;
	
	@Column(name="password")
	@NotNull
	private String password;
	
	@Column(name="gender")
	@NotNull
	private String gender;
	
	@Column(name="birth_date")
	@NotNull @DateTimeFormat(pattern="yyyy/mm/dd")
	private LocalDate birthDate;
	
	//교장은 0반에 소속
	@JoinColumn(name = "class_id")
	@ManyToOne()
	private Class classId;
	
	@Column(name = "user_type")
	@NotNull
	private String userType;
	
	////get,setter.///
	
	
	
}
