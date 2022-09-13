package com.kh.app01.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "notice/write";
	}
	
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(NoticeVo vo) {
		int result = service.write();
		System.out.println(vo);
		return "notice/write";
	}

}
