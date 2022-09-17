package com.kh.app05.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app05.member.dao.MemberDao;
import com.kh.app05.member.vo.MemberVo;
@Service
public class MemberServiceImpl implements MemberService{
		
		@Autowired
		private SqlSessionTemplate sst;
		
		@Autowired
		private MemberDao dao;

		@Override
		public int join(MemberVo vo) {
			return dao.join(sst , vo);
		}

		@Override
		public MemberVo login(MemberVo vo) {
			return dao.login(sst, vo);
		}

		@Override
		public MemberVo edit(MemberVo vo) {
			
			//업데이트 결과 확인하고, 다시 정보 조회
			int result = dao.edit(sst, vo);
			if(result == 1) {
				//다시 조회 해서 얻은 멤버를 리턴
//				MemberVo updatedMember = dao.selectOneById(sst, vo);
//				return updatedMember;
				
				return dao.selectOneById(sst, vo.getId());
			}else {
				return null;
			}
			
		}

		@Override
		public int quit(int memberNo) {
			return 0;
		}

	}

