package com.fjut.dao.impl;

import com.fjut.dao.UserDao;
import com.fjut.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/3 10:12
 * @param:
 * @return:
 * @throws:
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    @Override
    //用户注册的方法
    public void save(User user) {
              this.getHibernateTemplate().save(user);
    }

    @Override
    //用户登录的方法
    public User login(User user) {
        List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?",user.getUser_code(),user.getUser_password());
        if(list.size()>0){
            //登录成功
            return list.get(0);
        }
        return null;
    }
}
