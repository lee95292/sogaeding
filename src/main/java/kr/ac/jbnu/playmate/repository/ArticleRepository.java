package kr.ac.jbnu.playmate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.jbnu.playmate.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer>{

}
