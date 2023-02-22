package com.fastcampus.ch2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodCall {
     public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//          Hello hello = new Hello();
//          hello.main(); // private 외부 호출불가
          
          // Reflection API 사용 - 클래스 정보 얻고 다룰 수 있는 강력한 기능 제공
          // java.lang.reflect 패키지 제공
          // Hello 클래스의 Class 객체 (클래스의 정보를 담고 있는 객체 얻어옴)
          Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
          Hello hello = (Hello) helloClass.newInstance(); // 클래스가 가진 정보로 객체 생성
          Method main = helloClass.getDeclaredMethod("main");
          main.setAccessible(true); // private인 main()을 호출가능하게 함
          
          main.invoke(hello); // hello.main()
     }
}
