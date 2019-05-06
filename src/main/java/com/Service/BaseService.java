package com.Service;

import com.github.pagehelper.PageInfo;
import com.utils.Page;

import java.util.Map;

/**
 * Created by gengtao on 2019/4/4.
 */
public interface BaseService<T> {
    PageInfo<T> search(Map<String,Object> map,int pageNumber,int pageSize);

    void delete(Map<String,Object>map);

    void update(Map<String,Object>map);

    void add(Map<String,Object>map);
}
