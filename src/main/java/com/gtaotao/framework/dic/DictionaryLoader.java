package com.gtaotao.framework.dic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by davidcun on 2018/5/31.
 */
@Component
public class DictionaryLoader implements ApplicationContextAware,InitializingBean {
    private static boolean firstInit = true;

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

        if (firstInit) {
            firstInit = false;
            Map<String, DictionaryProvider> providers = context.getBeansOfType(DictionaryProvider.class);

            for (Map.Entry<String, DictionaryProvider> entry : providers.entrySet()) {

                DictionaryProvider provider = entry.getValue();

                List<Dictionary> list = provider.produce();

                if (list != null && list.size() > 0) {

                    for (Dictionary dic : list) {
                        DictionaryStorage.put(dic);
                    }

                }

            }

        }
    }
}
