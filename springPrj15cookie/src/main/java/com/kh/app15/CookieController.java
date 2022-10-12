package com.kh.app15;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cookie")
public class CookieController {
	
	@GetMapping("create")
	@ResponseBody
	public String cookie(HttpServletResponse resp) {
		
		//cookie/create에 들어올 때 쿠키를 구워서
		Cookie c = new Cookie("k01", "v01");
		//유통기한 24간짜리 쿠키
		c.setMaxAge(60 * 60 * 24);
		//이 쿠기가 보이는 경로 (만들어진 경로의 하위에서만 보여진다)
		c.setPath("/");
		
		//구운 쿠키를 클라이언트에게 전달
		resp.addCookie(c);
		
		return "cookie !!";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(HttpServletResponse resp) {
		
		Cookie c = new Cookie("k01","v01");
		c.setMaxAge(0);
		c.setPath("/");
		
		resp.addCookie(c);
		
		return "cookie delete ~~!";
	}
	
	@GetMapping("check")
	public String check() {
		return "check";
	}
	
	
	@GetMapping("check2")
	@ResponseBody
	public String check2(@CookieValue Cookie k01) {
		
		System.out.println(k01);
		System.out.println(k01.getName());
		System.out.println(k01.getValue());
		System.out.println(k01.getMaxAge());
		System.out.println(k01.getPath());
		
		return "check at controller ~~";
	}

}
