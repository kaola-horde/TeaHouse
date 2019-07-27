package com.chhliu.springboot.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.chhliu.springboot.quartz.config.QuartzConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties({QuartzConfigProperties.class} ) // 开启配置属性支持
public class SpringbootQuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuartzApplication.class, args);
	}
}
