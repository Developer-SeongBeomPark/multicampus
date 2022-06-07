package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ioc.SamsungTV;
import ioc.TV;

@SpringBootApplication
public class HellpAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellpAppApplication.class, args);
		
		 // 추가적인 입력 부분
    // 1.IoC 컨테이너 생성
    ApplicationContext context =
            new AnnotationConfigApplicationContext(TVConfig.class);
    
   // 2.LgTV Bean 가져오기
    TV lg = (TV)context.getBean("lgCreate");
    lg.powerOn();
    lg.volumeUp();
    lg.volumeDown();
    lg.powerOff();

    // 3.SamsungTV Bean 가져오기
    TV samsung = (TV)context.getBean("samsung", SamsungTV.class);
    samsung.powerOn();
    samsung.volumeUp();
    samsung.volumeDown();
    samsung.powerOff();
	}

}
