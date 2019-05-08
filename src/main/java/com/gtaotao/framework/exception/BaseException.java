/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.exception;

/**
 * Created by davidcun on 2014/11/27.
 *
 * @author davidcun
 */
public class BaseException extends RuntimeException {

    /**
     * 错误编码
     */
    protected String code;

    /**
     * 此字段是直接显示显示的消息
     */
    protected String errorMsg;

    /**
     * 可能错误信息是配置在配置文件里的，而且需要传递参数
     */
    protected String[] args;


    public void setCode(String code) {
        this.code = code;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public BaseException(ExceptionEvent event){
        this.code = event.getCode();
        this.errorMsg = event.getMessage();
        this.args = event.getArgs();
    }

    /**
     * 如果传入参数能够在配置文件中找到
     * 那么就说明相传如code，否则即使传入的提示信息，并且会默认默认赋值响应结果一个固定code
     * @param codeOrMsg
     */
    public BaseException(String codeOrMsg){
        super(codeOrMsg);
        this.setCode(codeOrMsg);
        this.setErrorMsg(codeOrMsg);
    }

    public BaseException(String code, String errorMsg){
        super(errorMsg);
        this.setCode(code);
        this.setErrorMsg(errorMsg);
    }
    public BaseException(String code, String errorMsg, Throwable cause){
        super(code,cause);
        this.setCode(code);
        this.setErrorMsg(errorMsg);
    }
    public BaseException(String code, String[] args){
        super(code);
        this.setCode(code);
        this.setArgs(args);
    }

    public BaseException(String codeOrMsg, Throwable cause){
        super(codeOrMsg,cause);
        this.setCode(codeOrMsg);
        this.setErrorMsg(codeOrMsg);
    }
    public BaseException(String code, String[] args, Throwable cause){
        super(code, cause);
        this.setCode(code);
        this.setArgs(args);
    }

    public String getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String[] getArgs() {
        return args;
    }

    public BaseException setArgs(String[] args){
        this.args = args;
        return this;
    }

}
