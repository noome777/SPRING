package com.kh.app99.member.service;

import com.kh.app99.member.vo.MemberVo;

public interface MemberService {
	
	
	//로그인
	MemberVo login(MemberVo vo);
	
	//회원가입
	int insertMember(MemberVo vo);

	//정보수정
	MemberVo edit(MemberVo vo);

	//아이디 중복확인
	int checkDup(String memberId);

	
	//정보조회
	
	
	//회원탈퇴

}
