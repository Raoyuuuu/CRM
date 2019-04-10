package com.fjut.dao.impl;

import com.fjut.dao.CustomerDao;
import com.fjut.domain.Customer;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/9 8:51
 * @param:
 * @return:
 * @throws:
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }
}
