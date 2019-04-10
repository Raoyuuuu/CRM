package com.fjut.service;

import com.fjut.domain.Customer;
import com.fjut.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    void save(Customer customer);


    PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer pageNumber, Integer pageSize);
}
