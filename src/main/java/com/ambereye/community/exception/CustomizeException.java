package com.ambereye.community.exception;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/22
 */
public class CustomizeException extends RuntimeException{

    private String message;
    private Integer code;


    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
