package com.fjut.web.action;

import com.fjut.domain.User;
import com.fjut.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

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


    //用户注册的方法
    public String register(){
        userService.register(user);
        return "login";
    }

    //用户登录的方法
    public  String login(){
        User existUser = userService.login(user);
        if(existUser==null){
            //登录失败
            this.addActionError("用户名或密码错误！");
            return LOGIN;
        }
        else{
            //登录成功
            ActionContext.getContext().getSession().put("existUser",existUser);
            return SUCCESS;
        }
    }

}
