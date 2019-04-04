package com.fjut.service.impl;

import com.fjut.dao.UserDao;
import com.fjut.domain.User;
import com.fjut.service.UserService;
import com.fjut.web.interceptor.MD5Utils;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/3 10:16
 * @param:
 * @return:
 * @throws:
 */
@Transactional
public class UserServiceImpl  implements UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao){
    this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        //加密处理
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        user.setUser_state("1");
        //调用DAO
        userDao.save(user);
    }
}
