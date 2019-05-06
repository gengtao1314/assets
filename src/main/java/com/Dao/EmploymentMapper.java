package com.Dao;

import com.Pojo.Employment;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentMapper{
    List<Employment> search(Map<String,Object> map);

    int countByMap(Map<String,Object>map);

    void deleteByMap(Map<String,Object>map);

    void batchInsert(List<Map<String,Object>> list);

    void batchUpdate(List<Map<String,Object>> list);
}