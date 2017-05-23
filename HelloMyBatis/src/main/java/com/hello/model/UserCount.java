package com.hello.model;

import org.apache.ibatis.type.Alias;

@Alias("UserCount")
public class UserCount {
	private int gender;
	private int count;

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "UserCount: [" + gender + ", " + count + "]";
	}
}
