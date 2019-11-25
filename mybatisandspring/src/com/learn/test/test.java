package com.learn.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.pojo.Flower;
import com.learn.service.FlowerService;
import com.learn.service.impl.FlowerServiceImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 默认去classes根目录下寻找
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		String[] names = ac.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
		FlowerService flowerService = ac.getBean("flowerService", FlowerServiceImpl.class);
		List<Flower> flowers = flowerService.show();
		System.out.println(flowers);
	}

}
