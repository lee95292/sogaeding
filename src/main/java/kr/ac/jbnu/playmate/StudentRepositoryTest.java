package kr.ac.jbnu.playmate;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import kr.ac.jbnu.playmate.model.Class;
import kr.ac.jbnu.playmate.model.Student;
import kr.ac.jbnu.playmate.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=StudentRepositoryTest.class,loader=AnnotationConfigContextLoader.class)
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testInsert() {
		Student student = new Student();
		student.setBirthDate(LocalDate.now());
		student.setGender("male");
		student.setMyclass(new Class());
		student.setPassword("test");
		student.setUserEmail("lee95292@baver,cin");
		student.setUserName("test");
		
		studentRepository.save(student);
		
	}
}
