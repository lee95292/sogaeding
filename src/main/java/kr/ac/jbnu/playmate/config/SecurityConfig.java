package kr.ac.jbnu.playmate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.ac.jbnu.playmate.service.impl.AuthProvider;
import lombok.extern.java.Log;

/*
 * Spring Security 참조 
 * @Authow wedul 님의
 * https://github.com/weduls/wedulpos_boot
 * */

@Log
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@ComponentScan(basePackages = {"kr.ac.jbnu.*"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	AuthProvider authProvider;
	
	@Autowired
	AuthFailureHandler authFailureHandler;
	
	@Autowired
	AuthSuccessHandler authSuccessHandler;
	
	@Override
	public void configure(WebSecurity web) throws Exception {	
		//허용되는 URL Mapping
		web.ignoring()
		.antMatchers("/resources/**",
					"/main/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

