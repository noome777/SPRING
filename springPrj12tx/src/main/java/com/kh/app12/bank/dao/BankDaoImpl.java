package com.kh.app12.bank.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDaoImpl implements BankDao {

	@Override
	public int plus(SqlSessionTemplate sst, int money) {
		return sst.update("bankMapper.plus", money);
	}

	@Override
	public int minus(SqlSessionTemplate sst, int money) {
		return sst.update("bankMapper.minus", money);
	}

}
