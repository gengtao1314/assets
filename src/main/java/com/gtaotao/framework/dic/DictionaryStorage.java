package com.gtaotao.framework.dic;



import com.gtaotao.framework.exception.BusinessException;
import com.gtaotao.framework.logging.Logger;
import com.gtaotao.framework.logging.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by davidcun on 2018/5/31.
 */
public class DictionaryStorage {


    private static final String key_code_split = "-_-";

    private static Logger logger = LoggerFactory.getLogger(DictionaryStorage.class);

    private static Map<String, Dictionary> db = new ConcurrentHashMap<String, Dictionary>();

    private static Dictionary error;

    static {
        error = new Dictionary("error", "-1", "找不到指定词典");
    }

    public static Dictionary get(String key) {

        List<Dictionary> list = new ArrayList<Dictionary>();

        Dictionary dc = new Dictionary("", "", "");

        for (Map.Entry<String, Dictionary> entry : db.entrySet()) {

            String kc = entry.getKey();

            String kcs[] = kc.split(key_code_split);

            if (kcs[0].equals(key)) {

                String parentKey = getDbKey(key, entry.getValue().getParentCode());

                Dictionary parent = db.get(parentKey);
                if (parent != null) {
                    if (!dc.getKey().equals("")) {
                        dc.setKey(parent.getKey());
                        dc.setCode(parent.getCode());
                        dc.setName(parent.getName());
                        dc.setParentCode(parent.getParentCode());
                    }
                    list.add(entry.getValue());
                }

            }
        }

        dc.setChildren(list);

        return dc;
    }

    public static Dictionary get(String key, String code) {

        Dictionary dc = db.get(getDbKey(key, code));

        return dc != null ? dc : error;
    }

    public static void put(Dictionary dic) {

        if (db.get(getDbKey(dic.getKey(),dic.getCode()))!=null){

            logger.error(String.format("数据字典key{%s}或者code{%s}已经存在",dic.getKey(),dic.getCode()));

            throw new BusinessException(String.format("数据字典key{%s}或者code{%s}已经存在",dic.getKey(),dic.getCode()));
        }

        db.put(getDbKey(dic.getKey(), dic.getCode()), dic);
    }

    private static String getDbKey(String key, String code) {
        return key + "-_-" + code;
    }
}
