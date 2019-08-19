package kr.ac.jbnu.playmate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="school")
public class School extends BaseEntity{

	@Column(name="address")
	private String address;
	
	@Column(name="school_name")
	private String name;
	
	@Column(name="identify_code")
	private Integer identifyCode;
} 