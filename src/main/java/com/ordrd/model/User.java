package com.ordrd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@NotEmpty
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotEmpty
	@Column(name = "LAST_NAME")
	private String lastName;

	@Digits(integer = 10, fraction = 0)
	@Column(name = "CONTACT_NO")
	private String contactNo;

	@Email
	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "FACEBOOK_ID")
	private String facebookId;

	@Column(name = "GOOGLE_ID")
	private String googleId;

	@Column(name = "PROFILE_PIC")
	private String profilePic;

	@Column(name = "LAST_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "ACTIVE_FLAG")
	private boolean activeFlag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User {\n\tid=").append(id).append("\n\tusername=").append(username)
				.append("\n\tpassword=").append(password).append("\n\tfirstName=")
				.append(firstName).append("\n\tlastName=").append(lastName)
				.append("\n\tcontactNo=").append(contactNo).append("\n\temailId=").append(emailId)
				.append("\n\tfacebookId=").append(facebookId).append("\n\tgoogleId=")
				.append(googleId).append("\n\tprofilePic=").append(profilePic)
				.append("\n\tlastLogin=").append(lastLogin).append("\n\trole=").append(role)
				.append("\n\tactiveFlag=").append(activeFlag).append("\n}");
		return builder.toString();
	}

}
