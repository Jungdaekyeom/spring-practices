package com.douzone.aoptest.service;

import org.springframework.stereotype.Service;

import com.douzone.aoptest.vo.ProductVo;

@Service
public class ProductService {

	// 핵심 관심
	public ProductVo find(String name) {
		System.out.println("[ProductService] finding...");
		
		// AfterThrowing 테스트를 위한 구문
		//		if(1-1==0) {
		//			throw new RuntimeException("Find Exception");	
		//		}
		
		return new ProductVo(name);
	}

}
