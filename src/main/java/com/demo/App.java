package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName App
 * @Description 启动类
 * @Author hyj
 * @Date 2019/4/8 10:51
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.demo.mapper")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
