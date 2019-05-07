/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.logging;

/**
 * Created by davidcun on 2014/11/5.
 * <p>
 * 日志超级接口
 * </p>
 */
public interface Logger {

    /**
     * 输出跟踪信息
     *
     * @param msg 信息内容
     */
    public void trace(String msg);

    /**
     * 输出跟踪信息
     *
     * @param e 异常信息
     */
    public void trace(Throwable e);

    public void trace(String msg, Throwable e);

    public void trace(String category, String msg);

    public void trace(String category, String msg, Throwable e);


    /**
     * 输出调试信息
     *
     * @param msg 信息内容
     */
    public void debug(String msg);

    /**
     * 输出调试信息
     *
     * @param e 异常信息
     */
    public void debug(Throwable e);



    /**
     * 输出调试信息
     *
     * @param msg 信息内容
     * @param e   异常信息
     */
    public void debug(String msg, Throwable e);

    public void debug(String category, String msg);

    public void debug(String category, String msg, Throwable e);

    /**
     * 输出普通信息
     *
     * @param msg 信息内容
     */
    public void info(String msg);

    /**
     * 输出普通信息
     *
     * @param e 异常信息
     */
    public void info(Throwable e);

    /**
     * 输出普通信息
     *
     * @param msg 信息内容
     * @param e   异常信息
     */
    public void info(String msg, Throwable e);

    public void info(String category, String msg);

    public void info(String category, String msg, Throwable e);

    /**
     * 输出警告信息
     *
     * @param msg 信息内容
     */
    public void warn(String msg);

    /**
     * 输出警告信息
     *
     * @param e 异常信息
     */
    public void warn(Throwable e);

    /**
     * 输出警告信息
     *
     * @param msg 信息内容
     * @param e   异常信息
     */
    public void warn(String msg, Throwable e);

    public void warn(String category, String msg);

    public void warn(String category, String msg, Throwable e);

    /**
     * 输出错误信息
     *
     * @param msg 信息内容
     */
    public void error(String msg);

    /**
     * 输出错误信息
     *
     * @param e 异常信息
     */
    public void error(Throwable e);

    /**
     * 输出错误信息
     *
     * @param msg 信息内容
     * @param e   异常信息
     */
    public void error(String msg, Throwable e);

    public void error(String category, String msg);

    public void error(String category, String msg, Throwable e);

    /**
     * 跟踪信息是否开启
     *
     * @return 是否开启
     */
    public boolean isTraceEnabled();

    /**
     * 调试信息是否开启
     *
     * @return 是否开启
     */
    public boolean isDebugEnabled();

    /**
     * 普通信息是否开启
     *
     * @return 是否开启
     */
    public boolean isInfoEnabled();

    /**
     * 警告信息是否开启
     *
     * @return 是否开启
     */
    public boolean isWarnEnabled();

    /**
     * 错误信息是否开启
     *
     * @return 是否开启
     */
    public boolean isErrorEnabled();


    public void forceAudit(String category, String msg);

}
