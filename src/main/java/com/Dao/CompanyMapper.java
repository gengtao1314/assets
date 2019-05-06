package com.Dao;

import com.Pojo.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CompanyMapper  {

    List<Company> search(Map<String,Object>map);

    int countByMap(Map<String,Object>map);

    void deleteByMap(Map<String,Object>map);

    void batchInsert(List<Map<String,Object>> list);

    void batchUpdate(List<Map<String,Object>> list);

}