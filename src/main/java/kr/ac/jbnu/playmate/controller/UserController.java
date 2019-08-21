package kr.ac.jbnu.playmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired(required = false)
	private UserRepository userRepository;
	
	@GetMapping("/register/{userType}")
	public String registerUser(@ModelAttribute User user, @PathVariable String UserType) {
		user.setUserType(UserType);
		userRepository.save(user);
		return "index.jsp";
	}
}
