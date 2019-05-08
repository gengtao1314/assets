package com.enums;

import com.gtaotao.framework.dic.Dictionary;
import com.gtaotao.framework.dic.DictionaryProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengtao on 2019/5/7.
 */
@Component
public class TestStatus implements DictionaryProvider{
    @Override
    public List<Dictionary> produce() {
        List<Dictionary> list = new ArrayList<Dictionary>();
        list.add(new Dictionary(TestStatus.class.getName(),"testStatus","测试状态"));
        list.add(new Dictionary(TestStatus.class.getName(),"1","通过","testStatus"));
        list.add(new Dictionary(TestStatus.class.getName(),"2","未通过","testStatus"));
        return list;
    }
}
