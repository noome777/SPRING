package com.kh.app99.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app99.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	//회원가입
	@Override
	public int insertOne(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("memberMapper.join", vo);
	}

	//로그인
	@Override
	public MemberVo selectOneById(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("memberMapper.selectOneById", vo);
	}

	@Override
	public int updateOne(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("memberMapper.updateOne", vo);
	}

	@Override
	public MemberVo selectOneByNo(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("memberMapper.selectOneByNo", vo.getNo());
	}

	//아이디 중복확인
	@Override
	public int selectCountId(SqlSessionTemplate sst, String memberId) {
		return sst.selectOne("memberMapper.selectCountId", memberId);
	}

	//회원 목록 조회
    @Override
    public List<MemberVo> selectList(SqlSessionTemplate sst) {
        return sst.selectList("memberMapper.selectList");
    }
	
	

}
