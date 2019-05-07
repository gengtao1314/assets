package com.gtaotao.framework.service;

import com.gtaotao.framework.common.page.PageResult;
import com.gtaotao.framework.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by gengtao on 2019/5/7.
 */
public interface IService<T extends BaseEntity, PK extends Serializable> {
    public T findOne(String prop, Object value);

    /**
     * 通过多个参数查询唯一数据
     * @param param
     * @return
     */
    public T findOne(Map<String, Object> param);

    public List<T> findByMap(Map<String, Object> param);

    public List<T> findByMap(Map<String, Object> param, String orderBy, boolean isAsc);

    public PageResult<T> findByMap(Map<String, Object> param, int start, int pageSize);

    public PageResult<T> findByMap(Map<String, Object> param, int start, int pageSize, String orderBy, boolean isAsc);

    public int create(T t);

    public int update(T t);
}
