package com.fjut.dao;

import com.fjut.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {
    void save(Customer customer);

    Integer findCount(DetachedCriteria detachedCriteria);


    List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

    Customer findById(Long cust_id);

    void delete(Customer customer);
}
