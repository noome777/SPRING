package com.kh.app13.member.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override
	public int join(String id, String pwd) {
		System.out.println("멤버 dao 호출됨");
		return 1;
	}

}
