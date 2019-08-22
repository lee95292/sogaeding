package kr.ac.jbnu.playmate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.playmate.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {	
	public Optional<User> findByLoginId(String loginId);
	public Optional<User> findByLoginIdAndPassword(String loginId,String password);
	
	
}
