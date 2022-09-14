package com.kh.app05.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app05.member.service.MemberService;
import com.kh.app05.member.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService ms;

	//회원가입(화면)
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	//회원가입
	@PostMapping("/join")
	public String join(MemberVo vo, Model model, HttpSession session) {
		int result = ms.join(vo);
		
		if(result == 1) {
			session.setAttribute("msg", "회원가입 성공");
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg","회원가입 실패");
			return "error";
		}
	}
	
	//로그인(화면)
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession session, Model model) {
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember != null) {
			session.setAttribute("msg", "로그인 성공");
			session.setAttribute("loginMember", loginMember);
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg", "로그인 실패");
			return "error";
		}
	}
	
	//로그인
	
	//정보 수정 (화면)
	@GetMapping("edit")
	public String edit(HttpSession session) {
		MemberVo vo = (MemberVo) session.getAttribute("loginMember");
		MemberVo loginMember = ms.login(vo);
		return "member/edit"; 
	}
	
	@GetMapping("edit")
	public String edit(MemberVo vo, HttpSession session) {
		MemberVo updatedMember = ms.edit(vo);
		if(updatedMember != null) {
			session.setAttribute("loginMember", loginMember);
		}
		return "redirect:/";
	}
	
	
	
}
