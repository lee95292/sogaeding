package kr.ac.jbnu.playmate.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.playmate.model.User;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Integer>{

	/*TODO : implements students */
	public User findById(Integer Id) throws DataAccessException;

	public  Collection<User> findByClassId(Integer Id) throws DataAccessException;

	public void save(User user) throws DataAccessException;
	
	@Query("SELECT count(*) from student")
	public Integer count();
}
