package com.gtaotao.framework.dataaccess.mybatis.plugin;

import com.gtaotao.framework.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by gengtao on 2019/5/7.
 */
public interface IBaseDao<T extends BaseEntity,PK extends Serializable> {
    public List<T> selectByMap(Map<String, Object> map);

    public T selectOne(Map<String, Object> map);

    public void batchInsert(List<T> list);

    public void batchUpdate(List<T> list);
}
