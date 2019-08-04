package com.us.test;

import java.util.Date;

import com.us.LoggerImpl;

public class Tester {

	public static void main ( String s[])
	{
		LoggerImpl l = new LoggerImpl();
		Date d = new Date();
		l.log(Thread.currentThread().getName(), d.getTime(), "ABCD");
		
		
	}
	
}
