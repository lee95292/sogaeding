package kr.ac.jbnu.playmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;

@Controller
public class UserController {
	
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	@PostMapping("/member/register")
	public String registerUser(@ModelAttribute User user) {
		if(userRepository==null) {
			System.out.println("its null____________________");
		}
		
		System.out.println(user.getGender()+user.getUserEmail()+"debbbb\n\n\n");
		userRepository.save(user);
		return "/main/main.jsp";
	}
}
