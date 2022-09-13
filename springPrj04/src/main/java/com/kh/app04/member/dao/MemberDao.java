package com.kh.app04.member.dao;

import com.kh.app04.member.vo.MemberVo;

public class MemberDao {
	
	public int join(SqlSessionTemplate sst, MemberVo vo) {
		return ss.insert("", vo);
	}

}
