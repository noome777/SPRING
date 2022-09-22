package com.kh.app14.board.controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVo {

	private String no;
	private String title;
	private String content;
	private MultipartFile[]
			f;			//file 객체가 전달됨
//	private List<MultipartFile> f;			//file 객체가 전달됨
	private String originName;
	private String filePath;
	private String enrollDate;
}
