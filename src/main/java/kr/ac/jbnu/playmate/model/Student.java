package kr.ac.jbnu.playmate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="student")
public class Student extends UserEntity{

}
