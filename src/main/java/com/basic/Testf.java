package com.basic;

import java.util.Calendar;
import java.util.Date;

public class Testf {

	public static void main(String[] args) {
		Calendar instance = Calendar.getInstance();
		
		instance.setTime(new Date());
		
		System.out.println(instance.get(Calendar.YEAR));
		System.out.println(instance.get(Calendar.MONTH) + 1); 
		System.out.println(instance.get(Calendar.DATE));
		
	}
	
}
