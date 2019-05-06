package com.Pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 数据字典持久化类
 */
@Component
public class BaseDict implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;          // 数据字典id
    private String type_code;  // 数据字典类别代码
    private String type_name;  // 数据字典类别名称
    private String item_name;  // 数据字典项目名称
    private String item_code;  // 数据字典项目代码
    private Integer sort;      // 排序字段
    private String enable;     // 是否可用
    private String memo;       // 备注

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String gettype_code() {
        return type_code;
    }

    public void settype_code(String type_code) {
        this.type_code = type_code;
    }

    public String gettype_name() {
        return type_name;
    }

    public void settype_name(String type_name) {
        this.type_name = type_name;
    }

    public String getitem_name() {
        return item_name;
    }

    public void setitem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getitem_code() {
        return item_code;
    }

    public void setitem_code(String item_code) {
        this.item_code = item_code;
    }

    public Integer getsort() {
        return sort;
    }

    public void setsort(Integer sort) {
        this.sort = sort;
    }

    public String getenable() {
        return enable;
    }

    public void setenable(String enable) {
        this.enable = enable;
    }

    public String getmemo() {
        return memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }
}
