package com.emrubik.springboot.app;

import com.emrubik.springboot.common.annotation.EnableCommon;
import com.emrubik.springboot.dao.annotation.EnableMybatis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCommon
@EnableMybatis
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
