package kr.ac.jbnu.playmate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.playmate.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Override
	default <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Optional<User> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Iterable<User> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	public Optional<User> findByLoginId(String loginId);
	public Optional<User> findByLoginIdAndPassword(String loginId,String password);
	
	
}
