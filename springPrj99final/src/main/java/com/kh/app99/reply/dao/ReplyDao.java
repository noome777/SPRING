package com.kh.app99.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app99.reply.vo.ReplyVo;

public interface ReplyDao {

    //댓글 작성
    int insertReply(SqlSessionTemplate sst, ReplyVo vo);

    //댓글 조회
    List<ReplyVo> selectList(SqlSessionTemplate sst, String no);

}
