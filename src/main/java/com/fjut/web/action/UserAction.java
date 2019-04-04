package com.fjut.web.action;

import com.fjut.domain.User;
import com.fjut.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/3 10:08
 * @param:
 * @return:
 * @throws:
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public String register(){
        userService.register(user);
        return "login";
    }


}
