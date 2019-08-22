package kr.ac.jbnu.playmate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.playmate.model.Article;
import kr.ac.jbnu.playmate.model.Class;


@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer>{
	public List<Article> findByArticleType(String articleType);
 	public List<Article> findByMyclassAndArticleTypeOrderByIdDesc(Class Myclass,String ArticleType);

}
