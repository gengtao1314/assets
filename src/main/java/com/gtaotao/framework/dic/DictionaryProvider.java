package com.gtaotao.framework.dic;

import java.util.List;

/**
 * Created by davidcun on 2018/5/31.
 */
public interface DictionaryProvider {


    /**
     * 生成所有字典逻辑
     * @return
     */
    public List<Dictionary> produce();


}
