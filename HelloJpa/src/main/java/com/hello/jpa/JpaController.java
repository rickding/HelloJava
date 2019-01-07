package com.hello.jpa;

import com.hello.jpa.dao.UserDO;
import com.hello.jpa.dao.UserDao;
import com.hello.jpa.validator.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
public class JpaController {
    Logger log = Logger.getLogger(JpaController.class.getName());

    @Autowired
    UserDao userDao;

    @RequestMapping("/add")
    public String add(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            StringBuffer sb = new StringBuffer();
            for (ObjectError item : result.getAllErrors()) {
                log.info(item.getDefaultMessage());

                sb.append(", ");
                sb.append(item.getDefaultMessage());
            }

            return sb.substring(2);
        }

        UserDO userDO = new UserDO(){{
            setId(userDao.count() + 1);
            setName(userModel.getName());
            setAccount(userModel.getAccount());
            setPwd(userModel.getPwd());

        }};

        userDao.save(userDO);
        return String.format("ok, %d", userDao.count());
    }
}
