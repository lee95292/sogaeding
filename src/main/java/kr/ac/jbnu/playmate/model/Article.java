package kr.ac.jbnu.playmate.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="board")
public class Article extends BaseEntity{
	
	/*
	 * 게시판 경로 : artType, classId
	 * 
	 * */
	// type 공지사항, 커뮤니티 ,
	@Column(name="article_type")
	private String articleType;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private Class myclass;
	
//	@OneToOne
//	@JoinColumn(name="author_id")
//	private User author;
//	
	@Column(name="content")
	private String content;
	
	@CreationTimestamp
	LocalDate createDate;
	
	@UpdateTimestamp
	LocalDateTime updateDate;

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public Class getMyclass() {
		return myclass;
	}

	public void setMyclass(Class myclass) {
		this.myclass = myclass;
	}

//	public User getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(User author) {
//		this.author = author;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	
	//@Column(name="s")
}
