package com.koreait.nemorecipe.exception;

public class FileHandleException extends RuntimeException{
	
	public FileHandleException(String msg) {
		super(msg);
	}
	
	public FileHandleException(Throwable e) {
		super(e);
	}
	
	public FileHandleException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
