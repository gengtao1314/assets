/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.controller;

/**
 * Created by davidcun on 2014/11/5.
 *
 * @author davidcun
 */
public class AbstractControllerResponse extends AbstractDto implements IControllerResponse {

    /**
     * 描述此次调用是否成功
     */
    private Boolean isSuccess = true;

    /**
     * 返回错误代码
     */
    private String code;

    /**
     * 返回消息提示
     */
    private String message;

    /**
     * 描述此次调用是否发生异常，不成功，不一定就异常
     */
    private Boolean isException = false;

    /**
     * 错误异常堆栈
     */
    private String stackTrace;

    /**
     * 如果正常返回的结果就可以放在
     */
    private Object result;

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsException() {
        return isException;
    }

    public void setIsException(Boolean isException) {
        this.isException = isException;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AbstractServiceResponse{" +
                "isSuccess=" + isSuccess +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", isException=" + isException +
                ", stackTrace='" + stackTrace + '\'' +
                '}';
    }
}
