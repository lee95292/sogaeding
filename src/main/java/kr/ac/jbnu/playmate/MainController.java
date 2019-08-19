package kr.ac.jbnu.playmate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Model model) {
		return "main";
	}
	
	@GetMapping("/member/signup")
	public String signUp(Model model) {
		return "signup";
	}
}
