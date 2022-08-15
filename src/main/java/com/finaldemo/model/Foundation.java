package com.finaldemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Foundation")
public class Foundation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foundationId;
	
	private Integer foundationMoney;
	
	private String foundationGmail;
	
	@OneToOne(mappedBy = "foundation")
	private Users user;
	
	public Foundation() {
	}

	public Integer getFoundationId() {
		return foundationId;
	}

	public Integer getFoundationMoney() {
		return foundationMoney;
	}

	public String getFoundationGmail() {
		return foundationGmail;
	}

	public Users getUser() {
		return user;
	}

	public void setFoundationId(Integer foundationId) {
		this.foundationId = foundationId;
	}

	public void setFoundationMoney(Integer foundationMoney) {
		this.foundationMoney = foundationMoney;
	}

	public void setFoundationGmail(String foundationGmail) {
		this.foundationGmail = foundationGmail;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
