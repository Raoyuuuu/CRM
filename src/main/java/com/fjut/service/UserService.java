package com.fjut.service;

import com.fjut.domain.User;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/3 10:15
 * @param:
 * @return:
 * @throws:
 */
public interface UserService {




    void register(User user);

    User login(User user);
}
