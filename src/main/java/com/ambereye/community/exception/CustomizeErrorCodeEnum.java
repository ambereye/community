package com.ambereye.community.exception;

public enum CustomizeErrorCodeEnum implements ICustomizeErrorCode{
    QUESTION_NOT_FUND(2001,"你找的问题不在了,请换个试试?"),
    TARGET_PARAM_NOT_FUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "未登录不能评论,请登录"),
    SYSTEM_ERROR(2004, "服务器太忙啦,请稍后再试");

    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCodeEnum(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
