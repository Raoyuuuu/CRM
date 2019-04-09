package com.fjut.dao.impl;

import com.fjut.dao.BaseDictDao;
import com.fjut.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/9 9:15
 * @param:
 * @return:
 * @throws:
 */
public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {
    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code=?",dict_type_code);
    }
}
