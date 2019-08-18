package kr.ac.jbnu.playmate.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

@MappedSuperclass
@Getter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Integer id;
}
