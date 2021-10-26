package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @author user
 * @RequestMapping 메소드 단독매핑
 */

// 메소드 단독매핑
@Controller
public class BoardController {

	@ResponseBody
	@RequestMapping("/board/write")
	public String write() {
		return "BoardController.write()";
	}

	@ResponseBody
	@RequestMapping("/board/view/{no}")
	// RequestMapping {no}와 PathVariable의 "no"를 맞춤
	// http://localhost:8080/hellospring03/board/view/199 입력
	public String view(@PathVariable("no") Long boardNo) {
		return "BoardController.view(" + boardNo + ")";
	}

}
