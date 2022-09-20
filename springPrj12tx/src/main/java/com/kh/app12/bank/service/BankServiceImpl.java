package com.kh.app12.bank.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app12.bank.dao.BankDao;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;
	
//	@Transactional(noRollbackFor = ArithmeticException.class)
	@Transactional
	@Override
	public int send(int money) {
		//비지니스 로직(트랜잭션)
		
		//보내는사람 마이너스
		int result1 = dao.minus(sst, money);
		
		//받는사람 플러스
		int result2 = dao.plus(sst, money);
		
		return result1 * result2;
	}

}
