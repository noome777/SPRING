package com.kh.app05.member.service;

import com.kh.app05.member.vo.MemberVo;

public interface MemberService {
	
	//회원가입
	int join(MemberVo vo);
	
	//로그인
	MemberVo login(MemberVo vo);
	
	//회원 정보 수정
	MemberVo edit(MemberVo vo);
	
	//회원 탈퇴
	int quit(int memberNo);
	

}
