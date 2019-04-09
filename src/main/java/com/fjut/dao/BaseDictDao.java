package com.fjut.dao;

import com.fjut.domain.BaseDict;

import java.util.List;

public interface BaseDictDao {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
