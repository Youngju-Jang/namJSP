package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	int iv = 10;
	static int cv = 20;
	
	@RequestMapping("/hello")
	private void main() { // 인스턴스 메서드
		System.out.println("hello-static");
		System.out.println(cv);
//		System.out.println(iv); // 가능
	}
	
	public static void main2(){ // static 메서드 - cv만 가능
		System.out.println(cv);
//		System.out.println(iv); // 에러
	}
}
