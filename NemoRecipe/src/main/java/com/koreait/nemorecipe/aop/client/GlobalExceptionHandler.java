package com.koreait.nemorecipe.aop.client;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koreait.nemorecipe.exception.LoginFailException;
import com.koreait.nemorecipe.exception.MemberExistException;


//모든 컨트롤러마다 일일이 중복된 예외를 처리하지말고, 공통된 예외를 처리할때는 예외처리 전용 컨트롤러를 이용할수
//있다..
@ControllerAdvice
public class GlobalExceptionHandler {

	//로그인 실패 예외처리 
	@ExceptionHandler(LoginFailException.class)
	public String handle(LoginFailException e, Model model) {
		model.addAttribute("e", e);
		return "error/result";
	}
	
	//위의 요청을 처리하는 메서드 중에서 , 어느것 하나라도 예외가 발생하면 아래의 메서드가 동작하게 됨
	@ExceptionHandler(MemberExistException.class)
	public String handleException(MemberExistException e, Model model) {
		model.addAttribute("e", e); //에러객체 저장
		
		return "error/result";
	}	
}
