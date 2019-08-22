package kr.ac.jbnu.playmate.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import kr.ac.jbnu.playmate.model.Class;
import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.UserRepository;
import kr.ac.jbnu.playmate.service.impl.UserServiceImpl;

@Controller
public class UserController {
	
	
	private UserRepository userRepository;
	private UserServiceImpl userService;
	
	public UserController(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	/*
	 * 회원가입 로직
	 * */

	/*
	 * 회원가입 로직
	 * */
	@PostMapping("/register")
	public RedirectView  registerUser(
			RedirectAttributes attributes,
			@ModelAttribute("User") User user,
			// exsclyy 학년 , exsclbb 반 
			@RequestParam(value = "gender") String gender,
			@RequestParam(value = "birthY") String birthY,
			@RequestParam(value = "birthM") String birthM,
			@RequestParam(value = "birthD") String birthD,
			@RequestParam(value = "subEmail1") String email1,
			@RequestParam(value = "subEmail2") String email2,
			@RequestParam(value = "exsclyy", required=false,defaultValue = "0") String exsclyy,
			@RequestParam(value = "exsclyy", required=false,defaultValue = "0") String exsclbb
			) {
			
			String email = email1.concat("@").concat(email2);
			int i_birthY = Integer.parseInt(birthY);
			int i_birthM = Integer.parseInt(birthM);
			int i_birthD = Integer.parseInt(birthD);
			
			LocalDate birthDate = LocalDate.of(i_birthY,i_birthM,i_birthD);
			user.setBirthDate(birthDate);
			user.setGender(gender);
			user.setUserEmail(email);
			Class classroom = new Class();
			int i_exsclyy = Integer.parseInt(exsclyy);
			int i_exsclbb = Integer.parseInt(exsclbb);
			
			classroom.setStudentGrade(i_exsclyy);
			classroom.setClassNumber(i_exsclbb);
			
			System.out.println(classroom.toString());
			System.out.println(user.toString());
			
			
			//System.out.println(user.getGender()+user.getUserEmail()+"debbbb\n\n\n");
			userRepository.save(user);
			
			return new RedirectView("/");
	}
	
	@RequestMapping(value= "/member/signup", method = RequestMethod.GET)
	public String signUp() {
		
		return "main/signup";
	}
}
