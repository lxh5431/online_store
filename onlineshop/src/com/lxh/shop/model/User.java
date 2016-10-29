package com.lxh.shop.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class User implements Serializable {

	private Integer id;
	private String username;
	private String name;
	private String pass;
	private String sex;
	private String phone;
	private String email;
	private Timestamp regTime;
    private String roleName;
	private Timestamp lastLogintime;
	private Set<Forder> forders = new HashSet<Forder>(0);
	private Set<Roles> roles = new HashSet<Roles>(0);
	public User() {
		super();
	}
	public User(String username, String name, String pass, String sex, String phone, String email,Set<Forder> forders) {
		super();
		this.username = username;
		this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.forders = forders;
	}
    public User(String username, String pass) {
    	this.username = username;
    	this.pass=pass;
	}
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "username", length = 20)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "pass", length = 20)
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(name = "sex", length = 20)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name = "phone", length = 20)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "email", nullable = true, length = 19)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "regTime", nullable = true, length = 19)
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	@Column(name = "roleName", length = 20)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Column(name = "lastLoginTime", nullable = true, length = 19)
	public Timestamp getLastLogintime() {
		return lastLogintime;
	}
	public void setLastLogintime(Timestamp lastLogintime) {
		this.lastLogintime = lastLogintime;
	}
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}*/
	
/*	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Forder> getForders() {
		return this.forders;
	}

	public void setForders(Set<Forder> forders) {
		this.forders = forders;
	}*/
	
	
}
