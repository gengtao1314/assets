package com.gtaotao.framework.dic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Created by davidcun on 2018/5/31.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionary implements Serializable {


    /**
     * 字典统一的key
     */
    private String key;

    /**
     * 当前字典的编码
     */
    private String code;

    /**
     * 当前字典的名字
     */
    private String name;

    /**
     * 当前字典的父亲编码
     */
    private String parentCode;

    /**
     * 所有的子节点
     */
    private List<Dictionary> children;


    public Dictionary(String key, String code, String name) {
        this(key,code,name,"0");
    }

    public Dictionary(String key, String code, String name, String parentCode) {
        this.key = key;
        this.code = code;
        this.name = name;
        this.parentCode = parentCode;
    }

    public List<Dictionary> getChildren() {
        return children;
    }

    public void setChildren(List<Dictionary> children) {
        this.children = children;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }


    @Override
    public String toString() {
        return "Dictionary{" +
                "key='" + key + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", children=" + children +
                '}';
    }
}
