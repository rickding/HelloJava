package com.hello.jpa;

import com.hello.jpa.dao.UserDO;
import com.hello.jpa.validator.UserModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserModelTest {
    Logger log = Logger.getLogger(UserModelTest.class.getName());

    @Autowired
    Validator validator;

    @Test
    public void testValidate() {
        // api: call with json body:
//        {
//            "name": "nass",
//                "account": "",
//                "pwd": 123
//        }

        // model:
        UserModel userDO = new UserModel();
//        userDO.setName("naa222);
        userDO.setAccount("acc333");
        userDO.setPwd("123");

        Set<ConstraintViolation<UserModel>> violationSet = validator.validate(userDO);
        for (ConstraintViolation<UserModel> model : violationSet) {
            log.info(model.getMessage());
        }
        Assert.assertTrue(violationSet.size() > 0);
    }
}
