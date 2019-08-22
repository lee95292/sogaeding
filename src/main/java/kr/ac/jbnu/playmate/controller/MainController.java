package kr.ac.jbnu.playmate.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.jbnu.playmate.model.Class;
import kr.ac.jbnu.playmate.model.School;
import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.ClassRepository;
import kr.ac.jbnu.playmate.repository.SchoolRepository;
import kr.ac.jbnu.playmate.repository.UserRepository;
import kr.ac.jbnu.playmate.service.impl.ArticleServiceImpl;
import kr.ac.jbnu.playmate.service.impl.UserServiceImpl;
import kr.ac.jbnu.playmate.util.MyAuthentication;

@Controller
public class MainController {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	ClassRepository classRepository;
	@Autowired
	UserServiceImpl userService;
	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	ArticleServiceImpl articleService;
	@Autowired
	private UserRepository userRepository;
	
	
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
	
	//@Secured("USER")
	@GetMapping("/class")
	public String classroom(MyAuthentication auth,Model model) {
		User user =auth.getUser();
		Class myclass=user.getClassId();
		model.addAttribute("myclass", myclass);
		
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
	@ResponseBody
	@GetMapping("/kk")
	public String test(MyAuthentication auth) {
		User user = auth.getUser();
		Class myclass= user.getClassId();
		//return myclass.getId().toString();
		return articleService.getArticles(myclass, "KEYWORD").toString();
	}
	@GetMapping("/genDefault")
	@ResponseBody
	public String genDefault() { 
		School school = new School();
		school.setAddress("addr");
		school.setIdentifyCode(1234);
		school.setName("cbnu");
		schoolRepository.save(school);
		
		Class myclass= new Class();
		myclass.setSchool(school);
		myclass.setStudentGrade(1);
		myclass.setClassNumber(1);
		classRepository.save(myclass);
		
		User user = new User();
		user.setBirthDate(LocalDate.now());
		user.setUserName("testname");
		user.setClassId(myclass);
		user.setLoginId("test");
		user.setGender("M");
		user.setPassword(passwordEncoder.encode("test"));
		user.setUserType("TEACHER");
		user.setUserEmail("asd@naver.com");
		userRepository.save(user);
		
		return "main/main";//school.toString()+myclass.toString()+user.toString();
	}
}
