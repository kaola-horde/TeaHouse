package com.chhliu.springboot.quartz;

import org.junit.Test;

public class RegexTest {
	@Test
	public void test(){
		String hello = "172.26.4.88";
		
		System.out.println(hello.matches("172.26.4.88"));
	}
}
