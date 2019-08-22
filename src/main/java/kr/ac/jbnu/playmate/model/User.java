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
	
	@Column(name="login_id")
	@NotNull
	private String loginId;
	
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
	@DateTimeFormat(pattern="yyyy/mm/dd")
	private LocalDate birthDate;
	
	//교장은 0반에 소속
	@JoinColumn(name = "class_id")
	@ManyToOne()
	private Class classId;
	
	/*
	 * user type
	 * 1. ADMIN
	 * 2. TEACHER
	 * 3. USER
	 * */
	@Column(name = "user_type")
	@NotNull
	private String userType;

	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

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

	public Class getClassId() {
		return classId;
	}

	public void setClassId(Class classId) {
		this.classId = classId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", loginId=" + loginId + ", userName=" + userName + ", password="
				+ password + ", gender=" + gender + ", birthDate=" + birthDate + ", classId=" + classId + ", userType="
				+ userType + "]";
	}
	
	////get,setter.///
	
	
	
	
}
