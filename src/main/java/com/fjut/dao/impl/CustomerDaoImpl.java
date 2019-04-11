package com.fjut.dao.impl;

import com.fjut.dao.CustomerDao;
import com.fjut.domain.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/9 8:51
 * @param:
 * @return:
 * @throws:
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

}
