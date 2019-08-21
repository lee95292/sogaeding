package kr.ac.jbnu.playmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;

@Controller
public class MainController {

	private UserRepository userRepository;
	
	public MainController (UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	@GetMapping("/")
	public String main(Model model) {
		return "main/main";
	}
	
	
}
