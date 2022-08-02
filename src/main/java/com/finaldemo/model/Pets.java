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
@Table(name="Pets")
public class Pets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petId;
	
	private String petName;
	
	private String petPhotoPath;
	
	private Integer petType;
	
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "Asia/Taipei") // JSON
	@DateTimeFormat(pattern = "yyyy/MM/dd") // SpringMVC
	@Temporal(TemporalType.TIMESTAMP)
	private Date petBirthday;
	
	private Integer petGender;
	
	private String petDescription;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_user_id")
	private Users userId;
	
	public Pets() {
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetPhotoPath() {
		return petPhotoPath;
	}

	public void setPetPhotoPath(String petPhotoPath) {
		this.petPhotoPath = petPhotoPath;
	}

	public Integer getPetType() {
		return petType;
	}

	public void setPetType(Integer petType) {
		this.petType = petType;
	}

	public Date getPetBirthday() {
		return petBirthday;
	}

	public void setPetBirthday(Date petBirthday) {
		this.petBirthday = petBirthday;
	}

	public Integer getPetGender() {
		return petGender;
	}

	public void setPetGender(Integer petGender) {
		this.petGender = petGender;
	}

	public String getPetDescription() {
		return petDescription;
	}

	public void setPetDescription(String petDescription) {
		this.petDescription = petDescription;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}
	
	
}
