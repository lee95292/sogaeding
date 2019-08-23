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
		Optional<User> user = userService.getUserByLoginId(id);
		User nullOrUser=user.orElse(new User());
		
		boolean pwMatch=passwordEncoder.matches(authentication.getCredentials().toString(),nullOrUser.getPassword());
		if(null == nullOrUser.getId()  || !pwMatch) {
			return null;
		}
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        String userType=nullOrUser.getUserType();
        
        // 로그인한 계정에게 권한 부여
        if(userType.equals("ADMIN")) {
    		grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else if(userType.equals("TEACHER")) {
    		grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
        }
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        
		return new MyAuthentication(id,nullOrUser.getPassword(),grantedAuthorityList,nullOrUser);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
