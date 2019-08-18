package kr.ac.jbnu.playmate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="principal")
public class Principal {
	
	@OneToOne
	@JoinColumn(/*TODO , school_id*/)
	private Integer school_id;
	
}
