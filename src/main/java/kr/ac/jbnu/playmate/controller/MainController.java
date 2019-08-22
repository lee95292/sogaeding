package kr.ac.jbnu.playmate.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;
import kr.ac.jbnu.playmate.service.impl.UserServiceImpl;
import kr.ac.jbnu.playmate.util.MyAuthentication;

@Controller
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MainController {

	@Autowired
	UserServiceImpl userService;
	private UserRepository userRepository;
	
	public MainController (UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	// main page
	@GetMapping("/")
	public String main(Model model,Principal principal) {
		if(principal!=null) {
			User user = userService.getUserByPrincipal(principal);
			model.addAttribute("User", user);
			return "classroom/classroom";
		}
			
		return "main/main";
	}
	// user 정보 
	@GetMapping("/user")
	   public String userInfo(MyAuthentication auth,Model model) {
	      model.addAttribute("User",auth.getUser());
	      return "main/user-info";
	   }
	
	@GetMapping("/class")
	public String classroom(MyAuthentication auth,Model model) {
		 model.addAttribute("User",auth.getUser());
		return "classroom/classroom";
	}
	@GetMapping("/class/v/{view_id}")
	public String cview(@PathVariable("view_id") String view_id) {
		
		System.out.println(view_id);
		String path1 = "classroom/cview";
		String path2 = path1.concat(view_id);
		return path2;	
	}
	
	// TEST CASE
	@GetMapping("/kk")
	@ResponseBody
	public String test(Principal principal) {
		return principal.getName();
	}
}
