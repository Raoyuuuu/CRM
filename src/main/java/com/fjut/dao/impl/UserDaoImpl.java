package com.fjut.dao.impl;

import com.fjut.dao.UserDao;
import com.fjut.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

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
    public void save(User user) {
              this.getHibernateTemplate().save(user);
    }
}
