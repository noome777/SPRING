package com.kh.app02.member.dao;

import org.springframework.stereotype.Repository;

import com.kh.app02.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Override
	public int join(MemberVo vo) {
		//ss.SQL 실행
		System.out.println("DAO ::: " + vo);
		return 1;
	}

	@Override
	public MemberVo login(MemberVo vo) {
		//ss.SQL ~~~
		System.out.println(vo);
		return new MemberVo();
	}

	@Override
	public MemberVo selectOneByNo(int MemberNo) {
		return null;
	}

	@Override
	public int edit(MemberVo vo) {
		return 0;
	}

	@Override
	public int quit(int memberNo) {
		return 0;
	}

}
