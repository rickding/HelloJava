package com.hello.spring.app;

public class HelloWorld {
	private String name;
	private String gender;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Spring 3: Hello " + name + "[" + gender + "]!");
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
