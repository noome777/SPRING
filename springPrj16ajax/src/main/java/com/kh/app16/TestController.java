package com.kh.app16;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
/* == controller + responsebody */
@RestController
public class TestController {
	
	@GetMapping("test01")
//	@ResponseBody ->RestController를 달아주면 전부 다 ResponseBody가 되기 때문에 따로 ResponseBody를 달아줄 필요 없다.
	public String test01(String k1) {
	    System.out.println("k1 ::: "+ k1);
		return "test01";
	}
	
	@GetMapping(value = "test02", produces = "text/plain; charset=UTF-8")
	public String test02(String age) {
	    
	    int x = Integer.parseInt(age);
	    if(x >= 20) {
	        return "성인입니다.";
	    }else {
	        return "미성년입니다.";
	    }
	}
	
	@GetMapping(value="test03", produces = "application/json; charset=UTF-8")
	public String test03() {
	    Gson gson = new Gson();
	    
	    HashMap<String, String> map = new HashMap<String, String>();
	    map.put("id", "user01");
	    map.put("pwd", "1234");
	    
	    String str = gson.toJson(map);
	    
	    return str;
	}

}
