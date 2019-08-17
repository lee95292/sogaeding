package kr.ac.jbnu.playmate;

import org.springframework.boot.SpringApplication;

//DB 설정 전에 일부러 강제 설정 => 설정후 삭제 
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan
@SpringBootApplication

//DB 설정하지 않은 상태 => 설정 후 삭제 
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class PlaymateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaymateApplication.class, args);
	}

	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
