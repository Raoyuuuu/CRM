package com.fjut.service.impl;

import com.fjut.dao.BaseDictDao;
import com.fjut.domain.BaseDict;
import com.fjut.service.BaseDictService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auther: raoyu
 * @Title:
 * @Description:
 * @Date: 2019/4/9 9:14
 * @param:
 * @return:
 * @throws:
 */
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao baseDictDao;
    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return baseDictDao.findByTypeCode(dict_type_code);
    }
}
