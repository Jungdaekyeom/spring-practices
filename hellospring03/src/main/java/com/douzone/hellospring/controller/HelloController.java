package com.douzone.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// @Controller 안달아두면 안된다.
@Controller
public class HelloController {

	// @RequestMapping은 DefaultAnnotationHandlerMapping에서
	// 컨트롤러를 선택할 때 대표적으로 사용하는 애노테이션이다.
	// url당 하나의 컨트롤러에 매핑되던 다른 핸들러 매핑과 달리 메서드 단위까지 세분화하여 적용할 수 있으며,
	// url뿐 아니라 파라미터, 헤더 등 더욱 넓은 범위를 적용할 수 있다.

	// 리퀘스트 매핑 안에 원래의 주소 + 주소 이름을 추가한다.
	// 내가 원하는 데로 다양하게 URL을 만들 수 있다.
	@RequestMapping("/hello1")
	// 해당 hello 함수 안에 파라미터를 집어넣는다.
	public String hello() {
		// 리턴을 파일 위치로 넘겨버리면 연결 가능.
		return "/WEB-INF/views/hello1.jsp";
	}

	@RequestMapping("/hello2")
	// 해당 hello 함수 안에 파라미터를 집어넣는다.
	// @RequestParam("n") String name으로 파라미터를 보내지만, n으로 치환해서 jsp파일로 전송
	public String hello2(String name) {
		System.out.println(name);
		return "/WEB-INF/views/hello2.jsp";
	}

	// /hello3과 hello4은 사실상 같다.
	// ModelAndView
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		// MovelAndView 중에서 View만 만듬
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}

	// 하지만 위와 비교했을 때, model을 쓰는 편이 코드상으로 훨씬 간결하다.
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello4.jsp";
	}

	// 여기서는 한글이 깨짐
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>Hello World / 안녕하세요! <h1>";
	}

	// 리다이렉트 하는 방법
	@RequestMapping("/hello6")
	public String hello6() {
		System.out.println("hello6() called");
		return "redirect:/hello1";
	}

	// void
	// HttpSession : 보안과 관련됨
	@RequestMapping("/hello7")
	public void hello7(HttpServletRequest req, HttpServletResponse resp, HttpSession session, Writer out)
			throws IOException {
		System.out.println("hello6() called");
		String no = req.getParameter("n");
		out.write("<h1>Hello World</h1>");
	}
}