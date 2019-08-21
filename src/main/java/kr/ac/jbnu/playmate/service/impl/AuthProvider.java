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

@Component("authProvider")
public class AuthProvider implements AuthenticationProvider{

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = authentication.getName();
		String password = passwordEncoder.encode(authentication.getCredentials().toString());
		String userType;
		Optional<User> user = userService.getUserByLoginId(id);
		
		if(null == user  /*TODO: ||비밀번호 검증*/) {
			return null;
		}else {
			userType=user.get().getUserType();
		}
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        
        // 로그인한 계정에게 권한 부여
        grantedAuthorityList.add(new SimpleGrantedAuthority(userType));
        

		return new MyAuthentication(id,password,grantedAuthorityList,user.get());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
