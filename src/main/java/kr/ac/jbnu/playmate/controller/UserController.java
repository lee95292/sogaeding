package kr.ac.jbnu.playmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;
import kr.ac.jbnu.playmate.service.UserService;

@Controller
@RequestMapping("/member")
public class UserController {
	
	
	private UserRepository userRepository;
	private UserService userService;
	
	public UserController(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	/*
	 * 회원가입 로직
	 * */
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user) {
		
		//System.out.println(user.getGender()+user.getUserEmail()+"debbbb\n\n\n");
		userRepository.save(user);
		return "/main/main.jsp";
	}
	
	
	@GetMapping("/signup")
	public String signUp(@ModelAttribute User user) {
		
		return "main/signup";
	}
}
