package com.kh.app99.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app99.common.FileUploader;
import com.kh.app99.member.service.MemberService;
import com.kh.app99.member.vo.MemberVo;

@Controller
@RequestMapping("member")
public class MemberController {
	
//	@Autowired
//	private MemberService ms;
	
	private final MemberService ms;
	
	@Autowired
	public MemberController(MemberService ms) {
		this.ms = ms;
	}

	//회원가입 (화면)
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	//회원가입 (진행)
	@PostMapping("join")
	public String join(MemberVo vo, HttpServletRequest req) {
		
		if(vo.getProfile() != null && !vo.getProfile().isEmpty()) {
			//프로필 파일 업로드 하지 않으면 문제발생 -> 파일 있을 때만 파일 업로드 해주기 , 파일 없으면 if문 다음 코드부터 진행
			//파일 업로드 후 저장된 파일명 얻기
			String savePath = req.getServletContext().getRealPath("/resources/upload/profile/");
			String changeName = FileUploader.fileUpload(vo.getProfile(), savePath);//파일업로드 클래스의 파일업로드 메소드 호출하기.
			vo.setFileName(changeName);
		}
		
		//서비스 호출
		int result = ms.insertMember(vo);
		
		//화면 선택
		if(result == 1) {
			return "redirect:/";
		}else {
			return "redirect:/errorPage";
		}
	}
	
	//로그인(화면)
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	//로그인
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession session, Model model) {
		MemberVo loginMember = ms.login(vo);
		
		if(loginMember != null) {
			//로그인 성공
			session.setAttribute("loginMember", loginMember);
			return "redirect:/";
		}else {
			//로그인 실패
			model.addAttribute("msg", "로그인 실패");
			return "common/error";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public String mypage() {
		return "member/mypage";
	}
}
