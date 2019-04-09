package com.fjut.service;

import com.fjut.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
