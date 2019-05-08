/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.exception;


/**
 * Created by davidcun on 2014/11/27.
 * 针对业务异常类型，在统一异常处理框架中，此类异常发生需要返回给前端json结构数据
 * 通常针对ajax请求的接口
 *
 * @author davidcun
 */
public class BusinessException extends BaseException {


    public BusinessException(ExceptionEvent event) {
        super(event);
    }

    public BusinessException(String codeOrMsg) {
        super(codeOrMsg);
    }

    public BusinessException(String code, String errorMsg) {
        super(code, errorMsg);
    }

    public BusinessException(String code, String errorMsg, Throwable cause) {
        super(code, errorMsg, cause);
    }

    public BusinessException(String code, String[] args) {
        super(code, args);
    }

    public BusinessException(String codeOrMsg, Throwable cause) {
        super(codeOrMsg, cause);
    }

    public BusinessException(String code, String[] args, Throwable cause) {
        super(code, args, cause);
    }
}
