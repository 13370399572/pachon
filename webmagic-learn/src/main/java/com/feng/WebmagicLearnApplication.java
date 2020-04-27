package com.feng;

import javax.servlet.MultipartConfigElement;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
/*@EnableAsync*/
@MapperScan(basePackages= {"com.feng.mybatisdao"})
public class WebmagicLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebmagicLearnApplication.class, args);
	}

	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
	   MultipartConfigFactory factory = new MultipartConfigFactory();
	   //  单个数据大小
	   factory.setMaxFileSize("102400KB");
	   /// 总上传数据大小
	   factory.setMaxRequestSize("102400KB");
	   
	   
	   return factory.createMultipartConfig();
	}
}
