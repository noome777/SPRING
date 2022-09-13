package com.kh.app04.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.app04.member.service.MemberService;
import com.kh.app04.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
//	@RequestMapping(value = "member/join", method = RequestMethod.GET)
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("member/join")
	public String join(MemberVo vo) {
		
		//서비스 호출
		int result = ms.join(vo);
		
		if(result == 1) {
			return "redirect:/";
		}else {
			return "error/errorPage";
		}
		
	}
	
}
