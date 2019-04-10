package com.fjut.dao.impl;

import com.fjut.dao.CustomerDao;
import com.fjut.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
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
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public void save(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    @Override
    // DAO中带条件统计个数的方法
    public Integer findCount(DetachedCriteria detachedCriteria) {
        // select count(*) from xxx where 条件;
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list  = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(list.size()>0){
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    //DAO中分页查询客户的方法
    public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
    }

    @Override
    //根据ID查询客户删除
    public Customer findById(Long cust_id) {
        return this.getHibernateTemplate().get(Customer.class,cust_id);
    }

    @Override
    //删除ID查询到的客户
    public void delete(Customer customer) {
        this.getHibernateTemplate().delete(customer);
    }
}
