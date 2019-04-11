package com.fjut.web.action;

import com.fjut.domain.Customer;
import com.fjut.domain.PageBean;
import com.fjut.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/9 8:48
 * @param:
 * @return:
 * @throws:
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    @Override
    public Customer getModel() {
        return customer;
    }

    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {

        this.customerService = customerService;
    }

    //新增客户保存
    public String save(){
        customerService.save(customer);
        return NONE;
    }



    //客户修改
    public  String update() {
            customerService.update(customer);
        return NONE;
    }

    //获取分页数据
    private Integer pageNumber=1;
    private Integer pageSize=5;

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //分页查询所有客户信息
    public String findAll() throws IOException {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        PageBean<Customer> pageBean =customerService.findByPage(detachedCriteria,pageNumber,pageSize);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total", pageBean.getTotalCount());
        map.put("rows", pageBean.getList());

        JSONObject jsonObject = JSONObject.fromObject(map);
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(jsonObject.toString());

        return NONE;
    }
    //通过ID查询客户再删除
    public String delete() {
        //先查询
        customer= customerService.findById(customer.getCust_id());

        //再删除
        customerService.delete(customer);
        return NONE;
    }
}
