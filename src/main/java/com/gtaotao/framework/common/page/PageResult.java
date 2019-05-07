/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.common.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidcun on 2014/11/6.
 *
 * @author davidcun
 */
public class PageResult<T> implements Serializable {

    private static int DEFAULT_PAGE_SIZE=30;

    private int start;

    private int totalCount;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private List<T> data;

    public PageResult() {
        this(0,0,DEFAULT_PAGE_SIZE,new ArrayList<T>());
    }

    public PageResult(int start, int totalCount, int pageSize, List<T> data) {
        this.start = start;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.data = data;
    }

    /**
     * 取总记录数
     *
     * @return 返回总记录数
     */
    public int getTotalCount() {
        return this.totalCount;
    }

    /**
     * 取总页数
     *
     * @return 返回总页数
     */
    public int getTotalPageCount() {
        if (totalCount % pageSize == 0)
            return totalCount / pageSize;
        else
            return totalCount / pageSize + 1;
    }

    /**
     * 取每页数据容量
     *
     * @return 返回每页数据容量
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 取当前页中的记录
     *
     * @return 返回当前页的记录数据
     */
    public List<T> getData() {
        return data;
    }

    /**
     * 设置分页数据
     * @param data
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * 取当前页码
     * 页码从1开始.
     *
     * @return 返回当前页码
     */
    public int getCurrentPageNo() {
        return start / pageSize + 1;
    }

    /**
     * 该页是否有下一页
     *
     * @return 返回是否有下一页
     */
    public boolean isHasNextPage() {
        return this.getCurrentPageNo() < this.getTotalPageCount();
    }

    /**
     * 该页是否有上一页
     *
     * @return 返回是否有上一页
     */
    public boolean isHasPreviousPage() {
        return this.getCurrentPageNo() > 1;
    }

    /**
     * 获取任一页第一条数据在数据集的位置
     * 每页条数使用默认值
     *
     * @return 返回任一页第一条数据在数据集的位置
     * @see #getStartOfPage(int,int)
     */
    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
    }

    /**
     * 获取任一页第一条数据在数据集的位置
     *
     * @param pageNo 从1开始的页号
     * @param pageSize 每页记录条数
     * @return 该页第一条数据
     */
    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 是否存在数据
     * @return
     */
    public boolean hasData() {
        if (null != this.getData() && this.getData().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当前页数据Size
     * @return
     */
    public int getDataSizeOfCurrentPage() {
        if (null != this.getData() && this.getData().size() > 0) {
            return this.getData().size();
        } else {
            return 0;
        }
    }
}
