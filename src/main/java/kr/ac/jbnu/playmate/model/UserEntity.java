package kr.ac.jbnu.playmate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class UserEntity extends BaseEntity{
	
	@Column(name="user_email")
	@NotNull
	protected String userEmail;
	
	@Column (name="name")
	@NotNull
	protected String name;
	
	@Column(name="password")
	@NotNull
	protected String password;
	
}
