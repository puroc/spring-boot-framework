package com.emrubik.springboot.common.annotation;

import com.emrubik.springboot.common.config.CommonAutoConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CommonAutoConfig.class)
@Documented
@Inherited
public @interface EnableCommon {
}