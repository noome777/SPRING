package com.kh.app04.member.controller;

import javax.servlet.http.HttpSession;

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
	
	@GetMapping("member/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("member/join")
	public String join(MemberVo vo) {
		
		//서비스 호출
		int result = ms.join(vo);
		
		if(result == 1) {
			//성공
			return "redirect:/";
		}else {
			//실패
			return "error/errorPage";
		}
		
		
		
	}
	
	//로그인 (화면)
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	//로그인 (실행)
	@PostMapping("/member/login")
	public String login(MemberVo vo, HttpSession session) {
		
		//서비스 호출
		MemberVo loginMember = ms.login(vo);
		
		
		if(loginMember != null) {
			//성공 -> 세션에 로그인유저의 값을 넣어 메인 화면으로 리다이렉트 해줌
			System.out.println(loginMember);
			session.setAttribute("loginMember", loginMember);
			return "redirect:/";
		}else {
			//실패
			System.out.println("로그인 실패");
			session.setAttribute("msg", "로그인 실패");
			//redirect는 viewResolver가 작업해주지 않으므로 확장자명(.jsp)을 다 적어준다.
			return "redirect:/error-page.jsp";
		}
	}
	

}//class
