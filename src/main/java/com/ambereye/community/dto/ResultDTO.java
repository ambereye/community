package com.ambereye.community.dto;

import com.ambereye.community.exception.CustomizeErrorCodeEnum;
import com.ambereye.community.exception.CustomizeException;
import lombok.Data;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/22
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;

    public static ResultDTO errorOf(Integer code,String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCodeEnum errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(),e.getMessage());
    }

    public static Object okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }

}
