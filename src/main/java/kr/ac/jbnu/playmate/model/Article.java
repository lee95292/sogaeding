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
	
	@OneToOne
	@JoinColumn(name="author_id")
	private User author;
	
	@Column(name="content")
	private String content;
	
	@CreationTimestamp
	LocalDate createDate;
	
	@UpdateTimestamp
	LocalDateTime updateDate;
	
	
	//@Column(name="s")
}
