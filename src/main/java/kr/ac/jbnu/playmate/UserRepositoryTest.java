package kr.ac.jbnu.playmate;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
@ContextConfiguration(classes=UserRepositoryTest.class,loader=AnnotationConfigContextLoader.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testInsert() {
		
		if(userRepository==null) {
			System.out.println("its null!!!!");
		}

		User user = new User();
		user.setBirthDate(LocalDate.now());
		user.setGender("male");
		user.setPassword("test");  
		user.setUserEmail("lee95292@baver,cin");
		user.setUserName("test");
		
		userRepository.save(user);
		
	}
}
