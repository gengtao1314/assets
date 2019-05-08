package com.gtaotao.framework.dic;

/**
 * Created by davidcun on 2018/5/19.
 */
public interface IDic<T extends IDic> {

    /**
     * 获取字典编码
     * @return
     */
    public String getCode();

    /**
     * 获取字典名称
     * @return
     */
    public String getName();


    /**
     * 通过编码获取字典
     * @param code
     * @return
     */
    public T getDic(String code);

}
