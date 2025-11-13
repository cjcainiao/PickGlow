package com.studentpulse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.studentpulse.mapper")  //开启扫描mapper层
public class PickGlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickGlowApplication.class, args);
	}

}
