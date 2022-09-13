package com.kh.app02.member.service;

import com.kh.app02.member.vo.MemberVo;

public interface MemberService {
	
	//회원가입
	/* public static*/ int join(MemberVo vo);
	
	//로그인
	/* public static*/ MemberVo login(MemberVo vo);
	
	//회원정보 조회 (마이페이지)
	/* public static*/ MemberVo selectOneByNo(int MemberNo);
	
	//회원정보 수정
	/* public static*/ int edit(MemberVo vo);
	
	//회원 탈퇴
	/* public static*/ int quit(int memberNo);
}
