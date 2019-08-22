package kr.ac.jbnu.playmate.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(value= "/register", method = RequestMethod.POST)
	public String registerUser(
			@ModelAttribute("User") User user,
			// exsclyy 학년 , exsclbb 반 
			@RequestParam(value = "gender") String gender,
			@RequestParam(value = "birthY") String birthY,
			@RequestParam(value = "birthM") String birthM,
			@RequestParam(value = "birthD") String birthD,
			@RequestParam(value = "subEmail1") String email1,
			@RequestParam(value = "subEmail2") String email2,
			@RequestParam(value = "exsclyy") String exsclyy,
			@RequestParam(value = "exsclbb") String exsclbb
			) {
			
			String email = email1.concat("@").concat(email2);
			int i_birthY = Integer.parseInt(birthY);
			int i_birthM = Integer.parseInt(birthM);
			int i_birthD = Integer.parseInt(birthD);
			
			LocalDate birthDate = LocalDate.of(i_birthY,i_birthM,i_birthD);
			user.setBirthDate(birthDate);
			user.setGender(gender);
			user.setUserEmail(email);
			
			System.out.println(user.toString());
			
			//System.out.println(user.getGender()+user.getUserEmail()+"debbbb\n\n\n");
			userRepository.save(user);
			
		return "main/main";
	}
	
	
	@RequestMapping(value= "/signup", method = RequestMethod.GET)
	public String signUp() {
		
		return "main/signup";
	}
}
