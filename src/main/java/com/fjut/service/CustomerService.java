package com.fjut.service;

import com.fjut.domain.Customer;
import com.fjut.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {



    PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer pageNumber, Integer pageSize);

    Customer findById(Long cust_id);

    void delete(Customer customer);

    void update(Customer customer);

    void save(Customer customer);
}
