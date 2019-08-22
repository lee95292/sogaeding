package kr.ac.jbnu.playmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.ac.jbnu.playmate.service.impl.ArticleServiceImpl;
import kr.ac.jbnu.playmate.service.impl.UserServiceImpl;
import kr.ac.jbnu.playmate.util.MyAuthentication;

@Controller
public class ArticleController {
	@Autowired
	UserServiceImpl userService;
	@Autowired
	ArticleServiceImpl articleService;
	
	//@Secured("TEACHER")
	@GetMapping("/keyadd/{content}")
	public void addKeyword(MyAuthentication auth,@PathVariable String content) {
		articleService.addArticle("keyword", auth.getUser(),content);
	}
	
}
