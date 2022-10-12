package com.kh.app99.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app99.reply.vo.ReplyVo;

@Repository
public class ReplyDaoImpl implements ReplyDao{

    //댓글 작성
    @Override
    public int insertReply(SqlSessionTemplate sst, ReplyVo vo) {
        return sst.insert("replyMapper.insertOne", vo);
    }

    //댓글 조회
    @Override
    public List<ReplyVo> selectList(SqlSessionTemplate sst, String no) {
        return sst.selectList("replyMapper.selectListByBno", no);
    }

}
