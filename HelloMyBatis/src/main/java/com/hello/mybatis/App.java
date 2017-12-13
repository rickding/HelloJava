package com.hello.mybatis;

import com.hello.mapper.ChannelOrderMapper;
import com.hello.mapper.SystemOrderMapper;
import com.hello.mapper.UserMapper;
import com.hello.model.ChannelOrder;
import com.hello.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    private static void checkChannelOrder(ChannelOrderMapper mapper) {
        List<ChannelOrder> list = mapper.selectAll();
        int count = list.size();
        System.out.println("Get channel order list, total: " + count);

        ChannelOrder order = null;
        if (count > 0) {
            order = list.get(0);
            System.out.println("Get channel order " + order.getOrderCode());
        } else {
            order = new ChannelOrder();
            order.setId(100);
            order.setOrderCode("test-as");
            order.setSourceContent("<order></order>");
            count = mapper.insert(order);
            System.out.println("Insert channel order " + order.getOrderCode() + ", insert: " + count);
        }

        order.setOrderCode(order.getOrderCode() + "-e" + order.getId());
        count = mapper.updateByPrimaryKey(order);
        System.out.println("Update channel order " + order.getOrderCode() + ", update: " + count);

        order = mapper.selectByPrimaryKey(order.getId());
        System.out.println("Select channel order " + order.getOrderCode());

        count = mapper.deleteByPrimaryKey(order.getId());
        System.out.println("Delete channel order " + order.getOrderCode() + ", delete: " + count);

        list = mapper.selectAll();
        count = list.size();
        System.out.println("Get channel order list, total: " + count);
    }

    private static void checkSystemOrder(SystemOrderMapper mapper) {

    }

    /**
     * @param args
     * @throws IOException
     */
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

            System.out.println("Total user count: " + String.valueOf(mapper.countUser()));

            List<?> lst = mapper.countUserByGender();
            System.out.println("Count user by gender: " + String.valueOf(lst));

            if (user == null)
                user = new User();

            user.setName(user.getName() + "i");
            mapper.insertUser(user);
            session.commit();

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

            System.out.println("************************");
            checkChannelOrder(session.getMapper(ChannelOrderMapper.class));
            session.commit();

            System.out.println("************************");
            checkSystemOrder(session.getMapper(SystemOrderMapper.class));
            session.commit();
        } finally {
            session.close();
        }
    }
}
