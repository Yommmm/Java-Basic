package com.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Teste {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		long time = sdf.parse("2019-04-10").getTime();
		System.out.println(time);
		
		long time1 = sdf.parse("2019-04-11").getTime();
		System.out.println(time1);
		
		System.out.println(time + 24 * 60 * 60 * 1000);
		
	}
	
}
