package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class RegisterController {

//     @RequestMapping ("/register/add")
//     @GetMapping ("/register/add")
//     public String register(){
//          return "registerForm";
//     }
	
//     @RequestMapping(value="/register/save", method = RequestMethod.POST)
     @PostMapping("/register/save")
     public String save(User user, Model m) throws Exception {
          // 1. 유효성 검사
          if(!isValid(user)){
               String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
              return "redirect:/register/add?msg="+msg; // URL 재작성
          }
          // 2. DB에 신규회원 정보 저장
          return "registerInfo";
     }
     
     private boolean isValid(User user) {
          return false;
     }
}
