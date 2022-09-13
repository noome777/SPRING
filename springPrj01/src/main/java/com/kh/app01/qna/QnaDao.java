package com.kh.app01.qna;

import org.springframework.stereotype.Repository;

@Repository
public class QnaDao {

	/**
	 * 문의 작성 진행
	 * @param vo
	 * @return
	 */
	public int write(QnaVo vo) {
		System.out.println(vo);
		return 1;
	}

}
