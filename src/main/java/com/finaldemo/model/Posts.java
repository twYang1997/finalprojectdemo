package com.finaldemo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Posts")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	private String postText;
	
	private String postVideoSrc;
	
	private Integer whoCanSeeIt;
	
	private Date postTime;
	
	private Integer whoShare;
	
	private Integer postLike;
	
	private Integer isReport;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_post_id")
	private Users userId;
	
	public Posts() {
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostVideoSrc() {
		return postVideoSrc;
	}

	public void setPostVideoSrc(String postVideoSrc) {
		this.postVideoSrc = postVideoSrc;
	}

	public Integer getWhoCanSeeIt() {
		return whoCanSeeIt;
	}

	public void setWhoCanSeeIt(Integer whoCanSeeIt) {
		this.whoCanSeeIt = whoCanSeeIt;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Integer getWhoShare() {
		return whoShare;
	}

	public void setWhoShare(Integer whoShare) {
		this.whoShare = whoShare;
	}

	public Integer getPostLike() {
		return postLike;
	}

	public void setPostLike(Integer postLike) {
		this.postLike = postLike;
	}

	public Integer getIsReport() {
		return isReport;
	}

	public void setIsReport(Integer isReport) {
		this.isReport = isReport;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}
	
	
}
