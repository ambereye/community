package com.ambereye.community.annotation;

import com.ambereye.community.annotation.processor.HasLoginProcessor;

import java.lang.annotation.*;

/**
 * HasLogin
 *
 * @see HasLoginProcessor
 * @author byference
 * @since 2019-10-12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface HasLogin {
}
