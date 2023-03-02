package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

// 년월일
@Controller
public class YoilTellerMVC5 {
	@ExceptionHandler(Exception.class)
     public String catcher(Exception ex) {
    	 ex.printStackTrace();
    	 return "yoilError";
     }
     @RequestMapping ("/getYoilMVC5") // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
     public String main(@ModelAttribute("myDate") Mydate date, Model model) throws IOException {
//     public String main(@ModelAttribute Mydate date, Model model) throws IOException {
          // 1. 유효성 검사
          if(!isValid(date))
               return "yoilError";  // 유효하지 않으면, /WEB-INF/views/yoilError.jsp로 이동
          // 2. 처리
          char yoil = getYoil(date);

          // 3. Model에 작업 결과 저장
//          model.addAttribute("myDate", date);
//          model.addAttribute("yoil", yoil);
          return "yoil"; // /WEB-INF/views/yoil.jsp
     }
     
     private @ModelAttribute("yoil") char getYoil(Mydate date){
          return getYoil(date.getYear(), date.getMonth(), date.getDay());
     }
     private char getYoil(int year, int month, int day) {
          Calendar cal = Calendar.getInstance();
          cal.set(year, month - 1, day);

          int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
          return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ...
     }
     private boolean isValid(Mydate date){
          return isValid(date.getYear(), date.getMonth(), date.getDay());
     }
     private boolean isValid(int year, int month, int day) {
          if(year==-1 || month==-1 || day==-1)
               return false;

          return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크
     }
}
