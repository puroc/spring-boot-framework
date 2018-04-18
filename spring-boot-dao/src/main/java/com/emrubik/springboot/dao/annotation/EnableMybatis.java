package com.emrubik.springboot.dao.annotation;

import com.emrubik.springboot.dao.config.MybatisPlusConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MybatisPlusConfig.class)//导入MybatisPlusConfig配置
@Documented
@Inherited
public @interface EnableMybatis {
}
