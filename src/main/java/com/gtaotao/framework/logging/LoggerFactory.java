/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.logging;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by davidcun on 2014/11/5.
 */
public class LoggerFactory {

    private static Map<String,WeakReference<Logger>> loggers = new ConcurrentHashMap<String, WeakReference<Logger>>();

    private LoggerFactory(){}

    public static Logger getLogger(String name){

        WeakReference<Logger> log = loggers.get(name);
        if(log==null){
            synchronized (loggers){
                if (log == null){
                    org.slf4j.Logger lo = org.slf4j.LoggerFactory.getLogger(name);
                    Logger logger = new Slf4jLogger(lo);
                    WeakReference<Logger> ref = new WeakReference<Logger>(logger);
                    loggers.put(name, ref);
                }
            }
        }
        return loggers.get(name).get();
    }

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }
}
