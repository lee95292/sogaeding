package kr.ac.jbnu.playmate.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import kr.ac.jbnu.playmate.model.Class;
import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.ClassRepository;
import kr.ac.jbnu.playmate.repository.SchoolRepository;
import kr.ac.jbnu.playmate.repository.UserRepository;

@Controller
@Validated
public class UserController {
	
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	ClassRepository classRepository;
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	private UserRepository userRepository;

	
	
	
	/*
	 * 회원가입 로직
	 * */

	/*
	 * 회원가입 로직
	 * */
	@PostMapping("/member/register")
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
			@RequestParam(value = "exsclyy", required=false,defaultValue = "1") String exsclyy,
			@RequestParam(value = "exsclyy", required=false,defaultValue = "1") String exsclbb
			) {

			String email = email1.concat("@").concat(email2);
			
			LocalDate birthDate = LocalDate.of(Integer.parseInt(birthY),Integer.parseInt(birthM),Integer.parseInt(birthD));
			
			user.setClassId(classRepository.findById(2).orElse(new Class()));
			
			user.setBirthDate(birthDate);
			user.setGender(gender);
			user.setUserEmail(email);
			
			
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			
			return new RedirectView("/");
	}
	
	@RequestMapping(value= "/member/signup", method = RequestMethod.GET)
	public String signUp() {
		
		return "main/signup";
	}
}
