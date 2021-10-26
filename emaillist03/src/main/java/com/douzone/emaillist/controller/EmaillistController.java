package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {

	// RootApplicationContext안의 Emaillist Repository에서
	// DI(의존성을 주입) 해서 WebApplicationContext 안의 EmaillistController를
	// 자동으로 묶어달라 : Autowired
	@Autowired
	private EmaillistRepository emaillistRepository;

	// model을 받아옴
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}

	// insert 후에는 redirect 해줘야 함
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}