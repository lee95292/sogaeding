package kr.ac.jbnu.playmate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.playmate.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	
}
