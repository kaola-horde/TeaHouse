package com.chhliu.springboot.quartz.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ScheduleTask {
	private static final Logger LOGGER =  LoggerFactory.getLogger(ScheduleTask.class);
	public void sayHello(){
		LOGGER.info("ScheduleTask===================>Hello world");
	}
}
