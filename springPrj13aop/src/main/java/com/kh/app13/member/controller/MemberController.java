package com.kh.app13.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app13.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("join")
	@ResponseBody
	public String join(String id, String pwd) {
		System.out.println("멤버 컨트롤러 호출됨");
		int result = service.join(id, pwd);
		
		if(result == 1) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
}
