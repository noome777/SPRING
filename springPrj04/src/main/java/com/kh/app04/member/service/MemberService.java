package com.kh.app04.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.app04.member.dao.MemberDao;
import com.kh.app04.member.vo.MemberVo;

public class MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@Autowired
	private MemberDao dao;
	
	public int join(MemberVo vo) {
		//커넥션 준비
		
		//dao 호출
		int result = dao.join(sst, vo);
		
		//실행결과 리턴
		return result;
	}

}
