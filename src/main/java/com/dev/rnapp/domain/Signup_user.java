package com.dev.rnapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Signup_user {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable =false,unique = true)
	private Long id;
	@NotBlank(message = "username is required")
	private String user_name;
	@NotBlank(message = "email is required")
	private String user_email;
	@NotBlank(message = "password is required")
	@Size(min=8, max = 30, message = "please use more than 8 character")
	private String user_password;
	@NotNull(message = "phone no is required")
	private int user_phone;
	@JsonFormat(pattern = "yyyy-mm--dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-mm--dd")
	private Date updated_At;

	public Signup_user() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(int user_phone) {
		this.user_phone = user_phone;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}


	@PrePersist	
	protected void onCreate() {
		this.created_At = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_At = new Date();
	}
}
