package com.kh.app99;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value= {"/", "home"})
	public String home() {
		return "home";
	}
}
