package kr.ac.jbnu.playmate.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jbnu.playmate.model.Article;
import kr.ac.jbnu.playmate.model.User;
import kr.ac.jbnu.playmate.repository.ArticleRepository;

@Service
public class ArticleServiceImpl {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Transactional
	public void addArticle(String type,User user,String content) {
		Article article = new Article();
		article.setArticleType(type);
		article.setAuthor(user);
		article.setContent(content);
		article.setMyclass(user.getClassId());
		
		articleRepository.save(article);
	}
	@Transactional
	public void addArticle(Article article) {
		articleRepository.save(article);
	}
	@Transactional
	public Iterable<Article> getArticles(Integer classId,String type ){
		return articleRepository.findArticleByMyclassAndArticleTypeOrderByIdDesc(classId, type);
	}
}
