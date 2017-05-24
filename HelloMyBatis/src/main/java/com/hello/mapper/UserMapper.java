package com.hello.mapper;

import java.util.List;

import com.hello.model.User;
import com.hello.model.UserCount;

public interface UserMapper {
	public User getUser(int id);

	public int countUser();

	public List<?> countUserByGender();

	public List<UserCount> countUserByGenderReturnResultMap();

	public void insertUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);
}
