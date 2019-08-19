package kr.ac.jbnu.playmate.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import kr.ac.jbnu.playmate.model.Student;

public interface StudentRepository{
	
	Student findById(Integer Id)throws DataAccessException;
	
	Collection<Student> findByClassId(Integer Id)throws DataAccessException;
	
	void save(Student student)throws DataAccessException;
}
