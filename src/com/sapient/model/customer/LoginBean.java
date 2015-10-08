package com.sapient.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "USERLOGIN")
public class LoginBean {

	@Id @GeneratedValue()
	@Column(name="ID", nullable = false)
	private long id;
	
	
	@Column(name="USERNAME", nullable = false)
	private String username;
	
	
	@Column(name="PASSWORD", nullable = false)
	private String password;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String uname) {
		this.username = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
