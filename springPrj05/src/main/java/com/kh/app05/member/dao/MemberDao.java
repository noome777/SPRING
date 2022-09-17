package com.kh.app05.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app05.member.vo.MemberVo;

public interface MemberDao {
	
	//회원가입
	int join(SqlSessionTemplate sst, MemberVo vo);
	
	//로그인
	MemberVo login(SqlSessionTemplate sst, MemberVo vo);
	
	//회원 정보 수정
	int edit(SqlSessionTemplate sst, MemberVo vo);
	
	//회원 탈퇴
	int quit(SqlSessionTemplate sst, int memberNo);

	//회원 조회 (아이디로)
	MemberVo selectOneById(SqlSessionTemplate sst, String string);


}
