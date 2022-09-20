package com.kh.app06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
	

	@GetMapping("/kh")
	public String kh(RedirectAttributes ra) {
		
		//쿼리스트링에 자동으로 붙음
		//http://127.0.0.1:8888/app06/test?k1=v1
		ra.addAttribute("k1","v1");
		ra.addAttribute("k2","v2");
		
//		return "redirect:/test/{k1}/{k2}";
		
		//세션에 담아서 새로고침을 할 때는 메세지가 그대로 남아있지만(세션에 안 담아둔 경우에는 메세지 없음), flash는 일회용이기 때문에 새로고침 시에 메세지가 사라짐
		//addFlashAttribute을 사용하면 HOME.JSP에서 remove할 필요 없다.
		ra.addFlashAttribute("msg", "일회용 알람~");
		
		return "redirect:/test";
	}
}
