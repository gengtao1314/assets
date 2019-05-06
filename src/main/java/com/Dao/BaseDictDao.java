package com.Dao;

import com.Pojo.BaseDict;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据字典
 */
@Repository
public interface BaseDictDao {
    // 根据类别代码查询数据字典
    public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
