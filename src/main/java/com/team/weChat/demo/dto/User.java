package com.team.weChat.demo.dto;

import javax.persistence.Table;

import com.team.mybatis.annotation.ExtensionAttribute;
import com.team.system.dto.BaseDTO;


@ExtensionAttribute(disable=true)
@Table(name = "user")
public class User extends BaseDTO {
	private static final long serialVersionUID = 1182600301312637420L;
	
	private Integer id;
	private String name;
	private String password;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
	
}
