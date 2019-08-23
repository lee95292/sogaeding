package kr.ac.jbnu.playmate.util;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import kr.ac.jbnu.playmate.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data 
@EqualsAndHashCode(callSuper = false)
public class MyAuthentication extends UsernamePasswordAuthenticationToken{
	private static final long  serialVersionUID =1L;
	
	String userId;
	String password;
	User user;
	
	public MyAuthentication(String id, String password, List<GrantedAuthority> grantedAuthorityList,User user) {
	    super(id, password, grantedAuthorityList);
	    this.userId = id;
	    this.password = password;
	    this.user=user;
	  }

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public User getUser() {
		return user;
	}
	
}
