package com.kh.app09.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@ToString
//@Getter
//@Setter
//@NoArgsConstructor				//생성자인데, 전달받는 값이 없는 == 기본생성자
//@AllArgsConstructor				//생성자인데, 모든 필드를 받는
//@RequiredArgsConstructor			//생성자인데, final 필드를 받는

@Data
public class MemberVo {

	
	private String id;
	private String pwd;
	private String nick;
	
	
}
