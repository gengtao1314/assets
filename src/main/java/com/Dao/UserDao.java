package com.Dao;

import com.Pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    List<User> search(Map<String,Object> map);

    int countByMap(Map<String,Object>map);

    void deleteByMap(Map<String,Object>map);

    void batchInsert(List<Map<String,Object>> list);

    void batchUpdate(List<Map<String,Object>> list);
}
