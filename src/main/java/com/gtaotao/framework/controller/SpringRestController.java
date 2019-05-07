package com.gtaotao.framework.controller;


import com.gtaotao.framework.exception.ExceptionEvent;
import com.gtaotao.framework.logging.Logger;
import com.gtaotao.framework.logging.LoggerFactory;
import com.gtaotao.framework.utils.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by davidcun on 2018/5/18.
 */
public abstract class SpringRestController implements IController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String SUCCESS_MESSAGE = "操作成功!";

    protected ResponseEntity<IControllerResponse> success(AbstractControllerResponse response) {
        return this.success(response, SUCCESS_MESSAGE);

    }

    protected ResponseEntity<IControllerResponse> success(AbstractControllerResponse response, String message) {
        response.setIsSuccess(true);
        response.setMessage(message);
        response.setCode(ExceptionEvent.successCode);
        return new ResponseEntity<IControllerResponse>(response, HttpStatus.OK);
    }

    protected ResponseEntity<IControllerResponse> exception(AbstractControllerResponse response, Throwable cause) {
        return this.exception(response,cause.getMessage(),cause);
    }

    protected ResponseEntity<IControllerResponse> exception(AbstractControllerResponse response, String message, Throwable cause){
        logger.error(message);
        response.setIsException(true);
        response.setIsSuccess(false);
        response.setMessage(message);
        response.setCode(ExceptionEvent.exceptionCode);
        response.setStackTrace(ExceptionUtils.getStackTrace(cause));
        return new ResponseEntity<IControllerResponse>(response, HttpStatus.OK);
    }

    protected ResponseEntity<IControllerResponse> error(AbstractControllerResponse response, String message){
        logger.error(message);
        response.setCode(ExceptionEvent.commonErrorCode);
        response.setIsSuccess(false);
        response.setIsException(false);
        response.setMessage(message);
        return new ResponseEntity<IControllerResponse>(response, HttpStatus.OK);
    }
    protected ResponseEntity<IControllerResponse> error(AbstractControllerResponse response, String code, String message){
        logger.error(message);
        response.setCode(code);
        response.setIsSuccess(false);
        response.setIsException(false);
        response.setMessage(message);
        return new ResponseEntity<IControllerResponse>(response, HttpStatus.OK);
    }
}
