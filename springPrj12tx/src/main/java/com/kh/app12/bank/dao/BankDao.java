package com.kh.app12.bank.dao;

import org.mybatis.spring.SqlSessionTemplate;

public interface BankDao {
	
	//플러스
	int plus(SqlSessionTemplate sst, int money);
	
	//마이너스
	int minus(SqlSessionTemplate sst, int money);

}
