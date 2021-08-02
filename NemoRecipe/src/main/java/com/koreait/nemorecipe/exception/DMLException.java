package com.koreait.nemorecipe.exception;

public class DMLException extends RuntimeException{
	
	public DMLException(String msg) {
		super(msg);
	}
	
	public DMLException(Throwable e) {
		super(e);
	}
	
	public DMLException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
