package com.koreait.nemorecipe.exception;

public class LoginFailException extends RuntimeException{
	
	public LoginFailException(String msg) {
		super(msg);
	}
	
	public LoginFailException(Throwable e) {
		super(e);
	}
	
	public LoginFailException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
