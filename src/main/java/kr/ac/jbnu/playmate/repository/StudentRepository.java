package kr.ac.jbnu.playmate.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.playmate.model.Student;

@Repository
public interface StudentRepository extends org.springframework.data.repository.Repository<Student, Integer>{

	
	public Student findById(Integer Id) throws DataAccessException;

	public  Collection<Student> findByClassId(Integer Id) throws DataAccessException;

	public void save(Student student) throws DataAccessException;
	
	@Query("SELECT count(*) from student")
	public Integer count();
}
