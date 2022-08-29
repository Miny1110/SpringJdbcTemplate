package com.exe.springJdbcTemplate;

import lombok.Getter;
import lombok.Setter;

/** 
 * @Getter : 게터 생성
 * @Setter : 세터 생성
 * @ToString: Object의 toString 오버라이드
 * @Data : 게터세터 생성

 * 위치는 위에 따로 써도 되고 public/private 뒤에 써도 된다.*/

@Getter
@Setter
public class CustomDTO {
	
	private int id;
	private String name;
	private int age;
	

}
