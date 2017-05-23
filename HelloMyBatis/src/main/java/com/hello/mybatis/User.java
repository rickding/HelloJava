package com.hello.mybatis;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {

	private int id;
	private String name;
	private int gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [" + id + ", " + name + ", " + (gender == 0 ? "male" : "female") + "]";
	}
}
