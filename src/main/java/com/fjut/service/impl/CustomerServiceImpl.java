package com.fjut.service.impl;

import com.fjut.dao.CustomerDao;
import com.fjut.domain.Customer;
import com.fjut.domain.PageBean;
import com.fjut.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/9 8:50
 * @param:
 * @return:
 * @throws:
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    public void setCustomerDao(CustomerDao customerDao) {

        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }


    @Override
    public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer pageNumber, Integer pageSize) {
        PageBean<Customer> pageBean = new PageBean<Customer>();
        // 封装当前页数:
        pageBean.setCurrPage(pageNumber);
        // 封装每页显示记录数:
        pageBean.setRows(pageSize);
        // 封装总记录数:
        // 调用DAO:
        Integer totalCount  = customerDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        // 封装总页数:
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        // 封装每页显示数据的集合
        Integer begin = (pageNumber - 1) * pageSize;
        List<Customer> list = customerDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
