package com.gtaotao.framework.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gtaotao.framework.common.page.PageResult;
import com.gtaotao.framework.dataaccess.mybatis.plugin.IBaseDao;
import com.gtaotao.framework.entity.BaseEntity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gengtao on 2019/5/7.
 */
public abstract  class AbstractService<T extends BaseEntity, PK extends Serializable> implements IService<T, PK> {
    protected abstract IBaseDao<T,PK> getMyBatisDao();

    @Override
    public T findOne(String prop, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(prop, value);
        return this.getMyBatisDao().selectOne(map);
    }

    @Override
    public T findOne(Map<String, Object> param) {
        return this.getMyBatisDao().selectOne(param);
    }

    @Override
    public List<T> findByMap(Map<String, Object> param) {
        return this.getMyBatisDao().selectByMap(param);
    }

    @Override
    public List<T> findByMap(Map<String, Object> param, String orderBy, boolean isAsc) {
        param.put("orderBy",orderBy);
        if(!isAsc){
            param.put("order","DESC");
        }
        return this.getMyBatisDao().selectByMap(param);
    }

    @Override
    public PageResult<T> findByMap(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<T> list = this.getMyBatisDao().selectByMap(param);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        if(pageInfo.getList().size()<1){
            return new PageResult<T>(pageNum,(int) pageInfo.getTotal(),pageSize, null);
        }else {
            return new PageResult<T>(pageNum, (int) pageInfo.getTotal(),pageSize,pageInfo.getList());
        }
    }

    @Override
    public PageResult<T> findByMap(Map<String, Object> param, int pageNum, int pageSize, String orderBy, boolean isAsc) {
        param.put("orderBy",orderBy);
        if(!isAsc){
            param.put("order","DESC");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<T> list = this.getMyBatisDao().selectByMap(param);
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        if(pageInfo.getList().size()<1){
            return new PageResult<T>(pageNum,(int) pageInfo.getTotal(),pageSize, null);
        }else {
            return new PageResult<T>(pageNum, (int) pageInfo.getTotal(),pageSize,pageInfo.getList());
        }
    }

    @Override
    public int create(T t) {
        return 0;
    }

    @Override
    public int update(T t) {
        return 0;
    }
}
