package com.finaldemo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificationId;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Asia/Taipei") // JSON
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") // SpringMVC
	@Temporal(TemporalType.TIMESTAMP)
	private Date notificationTime;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Users.class, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id", referencedColumnName = "userId")
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Posts.class, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_post_id", referencedColumnName = "postId")
	private Posts post;
	
	public Notification() {
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public Date getNotificationTime() {
		return notificationTime;
	}

	public void setNotificationTime(Date notificationTime) {
		this.notificationTime = notificationTime;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
	}
	
	
}
