package kr.ac.jbnu.playmate.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public class UserEntity extends BaseEntity{
	
	@Column(name="user_email")
	@NotNull
	protected String userEmail;
	
	@Column (name="user_name")
	@NotNull
	protected String userName;
	
	@Column(name="password")
	@NotNull
	protected String password;
	
	@Column(name="gender")
	@NotNull
	protected String gender;
	
	@Column(name="birth_date")
	@NotNull @DateTimeFormat(pattern="yyyy/mm/dd")
	protected LocalDate birthDate;
	
}
