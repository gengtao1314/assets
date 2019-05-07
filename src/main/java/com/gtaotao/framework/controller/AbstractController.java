/*
 * Copyright (c) 2014. kupat Corporation. All rights reserved.
 *  see statement on http://www.kupat.cn.
 */
package com.gtaotao.framework.controller;


import com.gtaotao.framework.exception.ExceptionEvent;
import com.gtaotao.framework.logging.Logger;
import com.gtaotao.framework.logging.LoggerFactory;
import com.gtaotao.framework.utils.ExceptionUtils;

/**
 * Created by davidcun on 2014/11/5.
 * <p/>
 * 服务抽象实现支持类，包括一些成功或者错误的设置等等
 *
 * @author davidcun
 */
public abstract class AbstractController implements IController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String SUCCESS_MESSAGE = "操作成功!";

    protected IControllerResponse success(AbstractControllerResponse response) {
        return this.success(response, SUCCESS_MESSAGE);

    }

    protected IControllerResponse success(AbstractControllerResponse response, String message) {
        response.setIsSuccess(true);
        response.setMessage(message);
        response.setCode(ExceptionEvent.successCode);
        return response;
    }

    protected IControllerResponse exception(AbstractControllerResponse response, Throwable cause) {
        return this.exception(response,cause.getMessage(),cause);
    }

    protected IControllerResponse exception(AbstractControllerResponse response, String message, Throwable cause){
        response.setIsException(true);
        response.setIsSuccess(false);
        response.setMessage(message);
        response.setCode(ExceptionEvent.exceptionCode);
        response.setStackTrace(ExceptionUtils.getStackTrace(cause));
        return response;
    }

    protected IControllerResponse error(AbstractControllerResponse response, String message){
        response.setCode(ExceptionEvent.commonErrorCode);
        response.setIsSuccess(false);
        response.setIsException(false);
        response.setMessage(message);
        return response;
    }
    protected IControllerResponse error(AbstractControllerResponse response, String code, String message){
        response.setCode(code);
        response.setIsSuccess(false);
        response.setIsException(false);
        response.setMessage(message);
        return response;
    }
}
