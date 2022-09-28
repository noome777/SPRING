package com.kh.app99.common;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {
	
	public static String fileUpload(MultipartFile f, String savePath) {
		
		//파일 업로드 ------ 우선, form의 enctype을 바꿔준다
		
		//0. 기존 파일 확장자 얻기(.jpg, .png)
//		MultipartFile f = vo.getProfile(); -> 파라미터에서 f를 전달받고 있으므로 주석처리
		String originName = f.getOriginalFilename();
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//1. 저장할 이름 만들기
		long now = System.currentTimeMillis();
		int random = (int)(Math.random() * 90000 + 10000);
		String changeName = now + "_" + random + ext; 
		//content-disposition 으로 이름 변경해서 추가 가능하다.
		
		//2. 서버에 업로드
		// 파일 객체 준비
		// 해당 파일에 전송
//		String savePath = req.getServletContext().getRealPath("/resources/upload/profile/");
		File target = new File(savePath + changeName);
		try {
			f.transferTo(target);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		//3. 디비에 저장 -> controller에서 처리
//		vo.setFileName(changeName);
		
		return changeName;
		
	}

}


