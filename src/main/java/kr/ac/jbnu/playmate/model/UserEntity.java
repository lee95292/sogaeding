package kr.ac.jbnu.playmate.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
	
	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
