package com.kh.app14.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardDownController {

	@GetMapping("down")
	public void down(HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setHeader("Content-Type", "application/octet-stream");
//		resp.setHeader("Content-Disposition", "attachment; filename=");
		resp.setHeader("Content-Length", "2081019");
		
		String rootPath = req.getServletContext().getRealPath("/resources/upload/");
		new File(rootPath + "temp.png");
		
		
	}
	
}
