package com.kh.app99.member.controller;

import java.io.File;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String login(MemberVo vo, HttpSession session, Model model, String saveId, HttpServletResponse resp) {
		
		System.out.println("saveId :: " + saveId);
		
		if(saveId != null) {
			//사용자가 아이디 저장을 원함(saveId에 체크함)
			Cookie c = new Cookie("rid", vo.getId());
			resp.addCookie(c);
		}
		
		
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
	
	@PostMapping("mypage")
	public String mypage(MemberVo vo, HttpServletRequest req, HttpSession session, Model model) {
		
		//파일 처리
		
		//기존 파일 삭제(처음 회원가입 시에 올렸던 프로필 사진)
		String savePath = req.getServletContext().getRealPath("/resources/upload/profile/");
		MemberVo loginMember = ((MemberVo) session.getAttribute("loginMember"));
		System.out.println("loginMember :::" + loginMember);
		
		String fileName = loginMember.getFileName();
		System.out.println("fileName :::" +fileName);
		
		File f = new File(savePath + fileName);
		System.out.println("f :::" +f);
		
		if(f.exists()) {
			f.delete();
		}
		
		//신규로 받은 파일 업로드, 저장된 파일명 얻기
		if(!vo.getProfile().isEmpty()){
			String changeName = FileUploader.fileUpload(vo.getProfile(), savePath);
			vo.setFileName(changeName);
		}
		
//		vo.setNo("세션에서 가져온 로그인 멤버의 번호")
		vo.setNo(loginMember.getNo());
		
		MemberVo updatedMember = ms.edit(vo);
		
		if(updatedMember != null) {
			//정보 수정 성공
			session.setAttribute("loginMember", updatedMember);
			return "redirect:/";
		}else {
			//정보 수정 실패
			model.addAttribute("errorMsg", "회원정보 수정 실패");
			return "error/errorPage";
		}
		
	}
	
	@PostMapping("/dup")
	@ResponseBody
	public String dup(String memberId) {
		System.out.println("ajax를 통해서 넘어온 userId :: " + memberId);
		
		int result = ms.checkDup(memberId);
		//return 값은 success와 error의 function의 data가 된다.
//		return "" + result;
		return String.valueOf(result);
	}
	

}
