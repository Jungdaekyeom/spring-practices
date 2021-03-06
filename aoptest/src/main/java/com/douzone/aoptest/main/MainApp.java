package com.douzone.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.aoptest.service.ProductService;
import com.douzone.aoptest.vo.ProductVo;

public class MainApp {
	public static void main(String[] args) {
		// config : resources에 있는 패키지
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");

		ProductService ps = ac.getBean(ProductService.class);
		// ps에서 상품을 찾아라
		ProductVo vo = ps.find("TV");
		System.out.println(vo);

		((AbstractXmlApplicationContext) ac).close();
	}

}
