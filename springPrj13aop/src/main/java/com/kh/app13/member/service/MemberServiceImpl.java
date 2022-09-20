package com.kh.app13.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app13.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao dao;
	
	@Override
	public int join(String id, String pwd) {
		System.out.println("멤버 서비스 호출됨 ~~");
		return dao.join(id, pwd);
	}

}
