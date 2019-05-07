/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.exception;

/**
 * Created by davidcun on 2014/11/27.
 * 此接口主要给枚举类继承，目的是为了一些抛异常的方便
 * <P>
 *     比如，定义枚举
 *     ErrorCode implements ExceptionEvent{
 *         UserNameNotExists("User1001","用户不存在");
 *         String code;
 *         String msg;
 *         ErrorCode(String code,String msg){
 *             this.code=code;
 *             this.msg=msg;
 *         }
 *     }
 * </P>
 *
 * @author davidcun
 */
public interface ExceptionEvent {

    /**
     * 表示调用成功
     */
    public static String successCode="200";
    public static String successCode_message="操作成功";
    /**
     * 发生异常的通用代码
     */
    public static String exceptionCode="300";
//    public static String exceptionCode_message="服务端发生异常";

    /**
     * 通用的错误编号
     */
    public static String commonErrorCode="400";

    /**
     * 未知错误代码
     */
    public static String unKnownErrorCode="500";
    public static String unKnownErrorCode_message="服务端发生未知异常";


    public String getCode();

    public String getMessage();

    public String[] getArgs();
}
