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
//		web.ignoring()
////		.antMatchers("/resources/**",
////					"/**");

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        // ROLE_USER, ROLE_ADMIN으로 권한 분리 유알엘 정의
        // 로그아웃 관련 설정
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
        .logoutSuccessUrl("/")
        .invalidateHttpSession(true)
        .and()
        //로그인 설정
      	.formLogin()
        .loginPage("/").loginProcessingUrl("/do_login")
        .failureHandler(authFailureHandler)
        .defaultSuccessUrl("/")
        .successHandler(authSuccessHandler)
        .usernameParameter("id")
        .passwordParameter("password")
//    .and()
//        // csrf 사용유무 설정
//        // csrf 설정을 사용하면 모든 request에 csrf 값을 함께 전달해야한다.
//        .csrf()
//        .disable()
    .and()
        // 로그인 프로세스가 진행될 provider
        .authenticationProvider(authProvider);
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

