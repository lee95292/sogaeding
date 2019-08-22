package kr.ac.jbnu.playmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//DB 설정하지 않은 상태 => 설정 후 삭제 
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class PlaymateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaymateApplication.class, args);
	}

	
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
