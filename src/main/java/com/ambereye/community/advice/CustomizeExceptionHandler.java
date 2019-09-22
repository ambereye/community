package com.ambereye.community.advice;

import com.alibaba.fastjson.JSON;
import com.ambereye.community.dto.ResultDTO;
import com.ambereye.community.exception.CustomizeErrorCodeEnum;
import com.ambereye.community.exception.CustomizeException;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/22
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable e, Model model,
                  HttpServletResponse response) {
        String contenType = request.getContentType();
        if ("application/json".equals(contenType)) {
            ResultDTO resultDTO = new ResultDTO();
            //返回json
            if (e instanceof CustomizeException) {
                resultDTO  = ResultDTO.errorOf((CustomizeException)e);
            } else {
                resultDTO  = ResultDTO.errorOf(CustomizeErrorCodeEnum.SYSTEM_ERROR);
            }
            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            return null;
        } else {
            //错误页面跳转
            if (e instanceof CustomizeException) {
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrorCodeEnum.SYSTEM_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
