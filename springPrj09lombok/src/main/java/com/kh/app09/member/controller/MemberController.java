package com.kh.app09.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app09.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("join")
	public String join() {
		return "join";
	}
	
	@PostMapping("join")
	public String join(MemberVo vo) {
		
		System.out.println(vo);
		
		return "redirect:/";
	}

}
