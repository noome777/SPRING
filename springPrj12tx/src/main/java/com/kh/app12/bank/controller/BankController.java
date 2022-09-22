package com.kh.app12.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app12.bank.service.BankService;

@Controller
@RequestMapping("bank")
public class BankController {
	
	@Autowired
	private BankService service;

	//송금 화면 보여주기
	@GetMapping("send")
	public String send() {
		return "bank/send";
	}
	
	//송금 진행
	@PostMapping("send")
	@ResponseBody /*resp.getWriter().write()*/
	public String send(int money) {
		
		System.out.println("입력받은 금액 : " + money);
		
		//계좌이체
		int result = service.send(money);
		
//		String msg = result == 1 ? "성공" : "실패";
		
		return result == 1 ? "성공" : "실패";
	}
}
