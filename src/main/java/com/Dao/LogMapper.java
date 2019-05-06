package com.Dao;

import com.Pojo.Company;
import com.Pojo.Log;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper{
    List<Log> search(Map<String,Object> map);

    int countByMap(Map<String,Object>map);

    void insert(Map<String,Object>map);
}