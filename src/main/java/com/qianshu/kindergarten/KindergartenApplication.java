package com.qianshu.kindergarten;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目启动类
 * (exclude = DataSourceAutoConfiguration.class) 取消数据库连接
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.qianshu.kindergarten.*"})
@MapperScan("com.qianshu.kindergarten.Mapper")
public class KindergartenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KindergartenApplication.class, args);
	}

}
