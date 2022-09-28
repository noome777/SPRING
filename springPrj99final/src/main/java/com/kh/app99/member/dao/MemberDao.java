package com.kh.app99.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app99.member.vo.MemberVo;

public interface MemberDao {

	// selectOne
	MemberVo selectOneById(SqlSessionTemplate sst, MemberVo vo);
	
	// selectAll
	
	// insertOne 회원가입
	int insertOne(SqlSessionTemplate sst ,MemberVo vo);

	
	// update
}
