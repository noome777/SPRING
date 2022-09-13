package com.kh.app01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

//	@Autowired
	private HomeDao dao;
	
	//나를 태어나게 하려면 dao를 가져다 줘라 !!
//	@Autowired
//	public HomeService(HomeDao dao) {
//		System.out.println("홈 서비스 객체 태어남");
//		this.dao = dao;
//	}
	
	
	@Autowired
	public void setDao(HomeDao dao) {
		System.out.println("서비스의 setter 호출됨");
		this.dao = dao;
	}
	
	public int home() {
		System.out.println("service 호출됨");
		int result = dao.home();
		return result;
	}

	
	

}
