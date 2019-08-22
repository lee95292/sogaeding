package kr.ac.jbnu.playmate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.playmate.model.Article;
import kr.ac.jbnu.playmate.model.Class;
import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.ArticleRepository;

@Service
public class ArticleServiceImpl {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Transactional
	public boolean addArticle(String type,User user,String content) {
		Article article = new Article();
		article.setArticleType(type);
		article.setContent(content);
		article.setMyclass(user.getClassId());
		
		if(articleRepository.save(article)==null)
			return false;
		
		return true;
	}
	@Transactional
	public void addArticle(Article article) {
		articleRepository.save(article);
	}
	@Transactional
	public List<Article> getArticles(Class myclass,String type){
		return articleRepository.findByMyclassAndArticleTypeOrderByIdDesc(myclass,type);
	}
}
