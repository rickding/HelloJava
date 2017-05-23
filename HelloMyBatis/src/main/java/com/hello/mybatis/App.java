package com.hello.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello MyBatis!");

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			User user = mapper.getUser(1);
			System.out.println(user != null ? user.toString() : "No result");

			int count = mapper.countUser();
			System.out.println("Total user count: " + String.valueOf(count));

			List<?> lst = mapper.countUserByGender();
			System.out.println("Count user by gender: " + String.valueOf(lst));
			
			if (user == null)
				user = new User();
			
			user.setName(user.getName() + "i");
			mapper.insertUser(user);
			session.commit();
			System.out.println("Count user by gender: " + String.valueOf(mapper.countUserByGenderReturnResultMap()));
			
			user.setGender((user.getGender() + 1) % 2); 
			mapper.updateUser(user);
			session.commit();
			System.out.println("Count user by gender: " + String.valueOf(mapper.countUserByGenderReturnResultMap()));
			
			mapper.deleteUser(user.getId());
			session.commit();
			System.out.println("Count user by gender: " + String.valueOf(mapper.countUserByGenderReturnResultMap()));
		} finally {
			session.close();
		}
	}
}
