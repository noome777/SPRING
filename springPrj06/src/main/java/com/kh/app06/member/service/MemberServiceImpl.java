package com.kh.app06.member.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.app06.member.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;
	
//	pom.xml에 spring security를 추가함
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public int join(Map<String, String> map) {
		//암호화
		String newPwd = encoder.encode(map.get("pwd"));
		map.put("pwd", newPwd);
		
		return dao.insert(sst, map);
	}

	@Override
	public Map<String, String> login(Map<String, String> map) {
		Map<String, String> dbMember = dao.selectOneById(sst, map.get("id"));
		
		String pwd1 = map.get("pwd");
		String pwd2 = dbMember.get("PWD");
		
		if(encoder.matches(pwd1, pwd2)) {
			return dbMember;
		}else {
			return null;
		}
			
	}

}
