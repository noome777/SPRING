package com.kh.app04.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app04.member.dao.MemberDao;
import com.kh.app04.member.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private SqlSessionTemplate sst;
	//TODO : SqlSessionTemplate 클래스를 가지고있는 라이브러리 추가
	
	@Autowired
	private MemberDao dao;
	
	public int join(MemberVo vo) {
		//트랜잭션 처리를 안 해주고, close를 안 해줌 -> spring 자체가 자동으로 commit || rollback을 해주고, close를 사용하면 에러가 남.
		
		//dao 호출
		int result = dao.join(sst, vo);
		
		//실행 결과 리턴
		return result;
		
	}

	//로그인
	public MemberVo login(MemberVo vo) {
//		MemberVo loginMember = dao.login(sst, vo);
//		return loginMember;
		
		return dao.login(sst, vo);
	}

}