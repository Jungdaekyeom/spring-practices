package com.douzone.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.fileupload.service.FileUploadService;

// applicationContext에서 설정해줌
@Controller
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping({ "", "/form" })
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}

	// 다중 파일 올릴 땐 form.jsp에서 file이름을 같게 한 후, MultipartFile을 배열로 처리
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(
			@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "file1") MultipartFile multipartfile,
			Model model) {

		System.out.println(email);

		// 위에서 fileuploadService을 주입받아야 함(의존성 주입인가?)
		String url = fileUploadService.restore(multipartfile);
		model.addAttribute("url", url);
		return "/WEB-INF/views/result.jsp";
	}

}
