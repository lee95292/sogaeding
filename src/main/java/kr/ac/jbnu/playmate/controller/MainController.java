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

	@GetMapping("/class")
	public String classroom(@ModelAttribute User user) {
		
		return "classroom/classroom";
	}
	@GetMapping("/class/{view_id}")
	public String cview(String view_id) {
		System.out.println(view_id);
		String path1 = "classroom/cview";
		String path2 = path1.concat(view_id);
		return path2;
		
	}
}
