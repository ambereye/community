package com.ambereye.community.exception;

public enum CustomizeErrorCodeEnum implements ICustomizeErrorCode{
    QUESTION_NOT_FUND("你找的问题不在了,请换个试试?");

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCodeEnum(String message) {
        this.message = message;
    }
}
