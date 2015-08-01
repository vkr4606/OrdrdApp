package com.ordrd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class UserQuery {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "RGSTRTN_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationTime;
	
	@Column(name="TYPE")
	private int type;
	
	@Column(name = "LSTUPDDT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
