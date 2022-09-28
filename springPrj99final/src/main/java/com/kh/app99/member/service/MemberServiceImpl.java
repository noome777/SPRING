package com.kh.app99.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app99.member.dao.MemberDao;
import com.kh.app99.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	//필드 인젝션
//	@Autowired
//	private SqlSessionTemplate sst;
	
//	@Autowired
//	private MemberDao dao;
	
	
	//생성자 인젝션
	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	private final PasswordEncoder pwdEnc;
	
	@Autowired
	public MemberServiceImpl(SqlSessionTemplate sst, MemberDao dao, PasswordEncoder pwdEnc) {
		this.sst = sst;
		this.dao = dao;
		this.pwdEnc = pwdEnc;
	}
	
	@Override
	public int insertMember(MemberVo vo) {
		
		//커넥션 준비
		//SQL
		//트랜잭션, 자원반납 -> 커넥션 풀 사용
		
		//암호화 -> MemberVo 에서 생성자로 처리 가능하다. vo.encodePwd(pwdEnc); 이 한 줄로 처리가 가능해짐.
//		String pwd = vo.getPwd();
//		String newPwd = pwdEnc.encode(pwd);
//		vo.setPwd(newPwd);
		
		vo.encodePwd(pwdEnc);
		
		
		
//		int result = dao.insertOne(sst, vo);
//		return result;
		return dao.insertOne(sst, vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		MemberVo dbMember = dao.selectOneById(sst, vo);
		
		//입력한 pwd == db의 pwd
		if(pwdEnc.matches(vo.getPwd(), dbMember.getPwd()) ) {
			return dbMember;
		}else {
			return null;
		}
			
	}

}
