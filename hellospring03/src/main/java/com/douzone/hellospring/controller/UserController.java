package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author user
 * @RequestMapping 클래스(타입) + 핸들러(메소드)
 *
 */

@Controller
// 공통적인 리퀘스트 매핑만 해줌
@RequestMapping("/user")
public class UserController {

	// @ResponseBody 뺌
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	// @ResponseBody 뺌
	// 위의 GET과 POST는 join 함수에 파라미터가 있냐 없냐의 차이
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/update")
	// @RequestParam("n") 파라미터로 넘어오는 값이 n
	// http://localhost:8080/hellospring03/user/update?n=123
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일 n이라는 이름의 파라미터가 없는 경우 400 bad request error가 발생
		 */
		System.out.println(name);
		return "UserController.update()";
	}

	@ResponseBody
	@RequestMapping("/update2")
	// @RequestParam("n") 파라미터로 넘어오는 값이 n
	// 값을 n으로 주고 required를 false로 하면, 꼭 n값이 없어도 된다는 의미
	// http://localhost:8080/hellospring03/user/update2?age=10&n=asdf 이런 식으로 입력
	// @RequestParam을 붙이고 난 다음에는 이런 식으로 출력
	// http://localhost:8080/hellospring03/user/update2
	public String update2(@RequestParam(value = "n", required = true, defaultValue = "고구마") String name,
			@RequestParam(value = "a", required = true, defaultValue = "0") Integer age) {

		System.out.println("----" + name + "----");
		System.out.println("----" + age + "----");
		return "UserController.update()";
	}
}
