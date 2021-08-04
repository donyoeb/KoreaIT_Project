package com.koreait.nemorecipe.aop.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.koreait.nemorecipe.exception.LoginFailException;

public class ClientSessionCheckAspect {

	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object[] args = joinPoint.getArgs(); //타겟 객체의 메서드 요청 시 넘어오는 매개변수
		HttpServletRequest request = null;
		HttpSession session = null;
		
		for(Object obj : args) {
			if(obj instanceof HttpServletRequest) { //넘어오는 매개변수가 HttpServletRequest 라면..
				request = (HttpServletRequest)obj;
			}
		}
		
		String uri = request.getRequestURI();
		
		Object result = null;
		if(uri.equals("/client/loginform") || uri.equals("/client/main") || uri.equals("/client/signin") || uri.equals("/client/login") || uri.equals("/client/signup")) {
			//검증이 필요 X
			result = joinPoint.proceed(); //원래의 메서드 호출 후, 반환 값을 받음
		}else {
			//검증이 필요 O
			session = request.getSession();
			if(session.getAttribute("member")==null) {
				throw new LoginFailException("로그인이 필요한 서비스입니다");
			}else {
				result = joinPoint.proceed(); //로그인 검증을 거친 사람은 원래 메서드 호출!!
			}
		}
		
		return result;
	}
}
