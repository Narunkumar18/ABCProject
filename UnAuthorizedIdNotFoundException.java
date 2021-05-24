package com.exceptions;
@SuppressWarnings("serial")
public class UnAuthorizedIdNotFoundException  extends Throwable{
	
	public  UnAuthorizedIdNotFoundException(String msg) {
		super(msg);
	}
}
