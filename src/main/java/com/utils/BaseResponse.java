package com.utils;

/**
 * Created by gengtao on 2019/4/4.
 */
public class BaseResponse {
    private Boolean success = Boolean.valueOf(true);

    private Boolean isException = Boolean.valueOf(false);

    private String code;

    private String message;

    private Object result;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getException() {
        return isException;
    }

    public void setException(Boolean exception) {
        isException = exception;
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
