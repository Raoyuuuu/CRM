package com.fjut.domain;

/**
 *CREATE TABLE `cst_customer` (
 *   `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
 *   `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
 *   `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
 *   `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
 *   `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
 *   `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
 *   `cust_email` varchar(16) DEFAULT NULL COMMENT '邮箱',
 *   PRIMARY KEY (`cust_id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */
public class Customer {
    private Long cust_id;
    private String cust_name;
    private String cust_phone;
    private String cust_email;

    private BaseDict baseDictSource;
    private BaseDict baseDictIndustry;
    private BaseDict baseDictLevel;

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }


    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public BaseDict getBaseDictSource() {
        return baseDictSource;
    }

    public void setBaseDictSource(BaseDict baseDictSource) {
        this.baseDictSource = baseDictSource;
    }

    public BaseDict getBaseDictIndustry() {
        return baseDictIndustry;
    }

    public void setBaseDictIndustry(BaseDict baseDictIndustry) {
        this.baseDictIndustry = baseDictIndustry;
    }

    public BaseDict getBaseDictLevel() {
        return baseDictLevel;
    }

    public void setBaseDictLevel(BaseDict baseDictLevel) {
        this.baseDictLevel = baseDictLevel;
    }
}
