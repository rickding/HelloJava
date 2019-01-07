package com.hello.jpa;

import com.hello.jpa.dao.UserDO;
import com.hello.jpa.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDOTest {
    Logger log = Logger.getLogger(UserDOTest.class.getName());

    @Autowired
    UserDao userDao;

    @Test
    public void testSave() {
        final long count = userDao.count();
        log.info(String.format("userDao count: %d", count));

        UserDO userDO = new UserDO();

        userDO.setId(count + 1);
        userDO.setName(String.format("n%d", userDO.getId()));
        userDO.setAccount(String.format("a%d", userDO.getId()));
        userDO.setPwd("123");

        log.info(userDO.toString());
        userDao.save(userDO);
        Assert.assertEquals(count + 1, userDao.count());
    }

    @Test
    public void testFindById() {
        List<UserDO> userDOList = userDao.findAll();
        if (userDOList != null && userDOList.size() > 0) {
            UserDO userDO = userDOList.get(userDOList.size() - 1);

            log.info(userDO.toString());
            Assert.assertEquals(userDao.count(), userDO.getId().longValue());
        }
    }

    @Test
    public void testFindByAccount() {
        UserDO userDO = userDao.findByAccount(String.format("a%d", userDao.count()));
        if (userDO != null) {
            log.info(userDO.toString());
            Assert.assertEquals(userDao.count(), userDO.getId().longValue());
        }
    }
}
