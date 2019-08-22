package kr.ac.jbnu.playmate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.util.MyAuthentication;

import java.lang.Exception;

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider{

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = authentication.getName();
		String password = authentication.getCredentials().toString();//passwordEncoder.encode(authentication.getCredentials().toString());
		System.out.println("\n\n\nid:"+id+" password:"+password);
		String userType="USER";
		Optional<User> user = userService.getUserByLoginId(id);
		User nullOrUser=user.orElse(new User());
		
		if(null == nullOrUser.getId()  /*TODO: ||비밀번호 검증*/) {
			return null;
		}else {
			userType=nullOrUser.getUserType();
			
		}
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        
        // 로그인한 계정에게 권한 부여
        grantedAuthorityList.add(new SimpleGrantedAuthority("User"));
        

		return new MyAuthentication(id,password,grantedAuthorityList,user.orElse(new User()));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
