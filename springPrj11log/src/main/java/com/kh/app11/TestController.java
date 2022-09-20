package com.kh.app11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {
	
//	private final Logger logger = LoggerFactory.getLogger(TestController.class);

	@GetMapping("test")
	@ResponseBody /*viewsResolver를 거치지 않기 때문에 .jsp 파일로 리턴하지 않고 , return의 값이 view 페이지에 글자 그대로 출력됨*/
	public String test(){
		//syso는 모든 걸 다 출력해주는데, logger는 레벨에 따라서 출력 유무가 달라진다.(아래는 로그 레벨 순서 : 기본값 info 수준으로 설정됨)
		log.trace("[트레이스] 로그 남기기 ~~~");
		log.debug("[디버그] 로그 남기기 ~~~");
		log.info("[인포] 로그 남기기 ~~~");
		log.warn("[경보] 로그 남기기 ~~~");
		log.error("[에러] 로그 남기기 ~~~");
		return "test~~~";
	}
}
