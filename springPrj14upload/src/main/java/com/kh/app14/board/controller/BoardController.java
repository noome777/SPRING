package com.kh.app14.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//게시글 작성(화면)
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	/*/
	 * 파일 업로드
	 * 
	 * 1. 라이브러리 등록
	 * 2. bean 등록
	 * 3. enctype, post 등 통신방시기 관련 설정
	 * 
	 * <주의사항>
	 * - form 태그의 method는 post로 작성
	 * - form 태그의 enctype 확인
	 * - 컨트롤러쪽 postMapping 확인
	 * - bean 틍록시, id 확인
	 * 
	 * - 파일 객체 받을 때 : MultipartFile
	 * - 파일 비어있는지 확인 : f.isEmpty()
	 * - 여러개 파일 받을 때 : MutipartFile []
	 * - 파일 비어있는지 확인 (여러개) :fArr[0].isEmpty()
	 */
	
	//게시글작성
	@PostMapping("/write")
	public String write(BoardVo vo, HttpServletRequest req) {
		
		MultipartFile[] fArr = vo.getF();
		
		//<파일 저장>
		//1. 파일이 있는지 확인
		if(!fArr[0].isEmpty()) {
			//클라이언트로부터 전달받은 파일 있음
			
			for(int i = 0; i<fArr.length; ++i) {
				MultipartFile f = fArr[i];
				
				//원본파일명
				String originName = f.getOriginalFilename();
				String ext = originName.substring(originName.lastIndexOf("."));	// .png
				
				//변경된 파일명 추출
				long now = System.currentTimeMillis();
				int randomNum = (int)(Math.random() * 90000 + 10000);
				String changeFileName = now + "_" + randomNum;
				
				//2. 파일 객체 생성
				String rootPath = req.getServletContext().getRealPath("/resources/upload/");
				File targetFile = new File(rootPath + changeFileName + ext);
				
				//3. 저장
				try {
					f.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			
			
}
		
		//2. 파일 객체 생성
		
		//3. 저장
		
		return "zzz";
	}
}
