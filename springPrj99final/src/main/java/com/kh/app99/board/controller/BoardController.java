package com.kh.app99.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app99.board.service.BoardService;
import com.kh.app99.board.vo.BoardVo;
import com.kh.app99.common.PageVo;
import com.kh.app99.common.Pagination;
import com.kh.app99.member.vo.MemberVo;
import com.kh.app99.reply.service.ReplyService;
import com.kh.app99.reply.vo.ReplyVo;

@Controller
@RequestMapping("board")
public class BoardController {
    
    private final BoardService bs;
    private final ReplyService rs;
    
    @Autowired
    public BoardController(BoardService bs , ReplyService rs) {
        this.bs = bs;
        this.rs = rs;
    }

    // 목록 조회 (화면)
    @GetMapping("list/{pno}")
    public String list(Model model , @PathVariable int pno) {
        
        
        int totalCount = bs.selectTotalCnt();
        
        PageVo pv = Pagination.getPageVo(totalCount, pno, 5, 10); 
        
        //디비 데이터 조회
        List<BoardVo> voList = bs.selectList(pv);
        
        model.addAttribute("voList" , voList);
        model.addAttribute("pv" , pv);
        return "board/list";
    }
    
    //게시글 작성 (화면)
    @GetMapping("write")
    public String write() {
        return "board/write";
    }
    
    //게시글 작성
    @PostMapping("write")
    public String write(BoardVo vo , Model model , HttpSession session) {
        
        MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
        String no = loginMember.getNo();
        
        vo.setWriter(no);
        
        //디비 다녀오기
        int result = bs.write(vo);
        
        //화면 선택
        if(result == 1) {
            session.setAttribute("alertMsg", "게시글 작성 성공!");
            return "redirect:/board/list/1";
        }else {
            model.addAttribute("msg" , "게시글 작성 실패...");
            return "error/errorPage";
        }
        
    }
    
    //게시글 상세조회
    @GetMapping("detail/{no}")
    public String detail(@PathVariable String no , Model model) {
        
        //디비 가서 게시글 1개 조회 (번호로)
        BoardVo vo = bs.selectOne(no);
        
        //디비 가서 댓글 조회
        List<ReplyVo> replyList = rs.selectList(no);
        
        model.addAttribute("vo", vo);
        model.addAttribute("replyList" , replyList);
        return "board/detail";
    }
    
    @GetMapping("edit/{no}")
    public String edit(@PathVariable String no , Model model) {
        BoardVo vo = bs.selectOne(no);
        model.addAttribute("vo" , vo);
        return "board/edit";
    }
    
    //게시글 수정
    @PostMapping("edit/{no}")
    public String edit(@PathVariable String no , BoardVo vo, HttpSession session) {
        
        vo.setNo(no);
        
        //디비 다녀오기
        int result = bs.edit(vo);
        
        if(result == 1) {
            //성공 화면 
            session.setAttribute("alertMsg", "게시글 수정 성공!!!");
            return "redirect:/board/detail/" + no;
        }else {
            //실패
            session.setAttribute("alertMsg", "게시글 수정 실패...");
            return "redirect:/";
        }
        
    }
    
    
    //삭제하기
    @GetMapping("delete/{no}")
    public String delete(@PathVariable String no , HttpSession session , Model model) {
        
        int result = bs.delete(no);
        
        if(result == 1) {
            //삭제성공 => 알람 , 리스트
            session.setAttribute("alertMsg", "게시글 삭제 성공!");
            return "redirect:/board/list/1";
        }else {
            //삭제실패 => 메세지 , 에러페이지
            model.addAttribute("msg", "게시글 삭제 실패 ...");
            return "common/errorPage";
        }
        
    }
    
    
    
}//class























