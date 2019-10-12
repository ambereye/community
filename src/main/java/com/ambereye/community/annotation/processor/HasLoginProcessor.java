package com.ambereye.community.annotation.processor;

import com.ambereye.community.annotation.HasLogin;
import com.ambereye.community.dto.ResultDTO;
import com.ambereye.community.exception.CustomizeErrorCodeEnum;
import com.ambereye.community.exception.CustomizeException;
import com.ambereye.community.model.User;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * HasLoginProcessor
 *
 * @author byference
 * @since 2019-10-12
 */
//@Aspect
//@Component
public class HasLoginProcessor {


    @Before("@annotation(hasLogin)")
    public void process(JoinPoint joinPoint, HasLogin hasLogin) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new CustomizeException(CustomizeErrorCodeEnum.NO_LOGIN);
        }

//        // joinPoint 拿到 参数
//        if (commentDTO == null || StringUtils.isBlank(commentDTO.getContent())) {
//            throw new CustomizeException(CustomizeErrorCodeEnum.COMMENT_IS_EMPTY);
//        }

    }

}
