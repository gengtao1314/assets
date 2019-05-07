/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.controller;


import com.gtaotao.framework.entity.BaseEntity;

/**
 * Created by davidcun on 2014/11/5.
 *
 * @author davidcun
 */
public abstract class AbstractControllerRequest<T extends BaseEntity> extends AbstractDto implements IControllerRequest {

    /**
     * 默认从0开始查询
     */
    private Integer start = 0;

    /**
     * 默认分页大小为20
     */
    private Integer pageSize = 20;

    /**
     * 针对新增的时候就可以用这个属性
     */
    private T entity;


    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
