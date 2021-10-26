package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// #Controller 달아주고 임포트
@Controller
public class MainController {
	// http://localhost:8080/hellospring03/main/a/b/c/d
	// #RequestMapping, #ResponseBody 달아주고 임포트
	@ResponseBody
	@RequestMapping({ "", "/main", "/main/a/b/c/d" }) // 복수 매핑 가능
	public String main() {
		return "MainController.main()";
	}

}
