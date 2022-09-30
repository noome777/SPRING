package com.kh.app99.approval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("approval")
public class ApprovalController {
	
	
	@GetMapping("main")
	public String approval() {
		return "approval/approvalMain";
	}
	
	@GetMapping("approvalInsert")
	public String approvalInsert() {
		return "approval/approvalInsert";
	}
	
}
