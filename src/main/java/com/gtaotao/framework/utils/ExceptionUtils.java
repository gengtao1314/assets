/*
 * Copyright (c) 2015. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by davidcun on 2014/11/27.
 *
 * @author davidcun
 */
public class ExceptionUtils {

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }


    /**
     * 将CheckedException转换为UncheckedException.
     */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        } else {
            return new RuntimeException(e);
        }
    }
}
