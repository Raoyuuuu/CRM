package com.fjut.service.impl;

import com.fjut.dao.CustomerDao;
import com.fjut.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

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
}
