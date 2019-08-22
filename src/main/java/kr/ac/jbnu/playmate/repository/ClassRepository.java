package kr.ac.jbnu.playmate.repository;

import kr.ac.jbnu.playmate.model.Class;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<Class, Integer>{
	Optional<Class> findAclassById(Integer Id);
	Optional<Class> findAclassByClassTeacher(Integer Id);
}
