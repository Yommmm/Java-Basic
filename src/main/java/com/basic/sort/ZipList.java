package com.basic.sort;

import java.util.Arrays;
import java.util.List;

public class ZipList {

	public static void main(String[] args) {
		String aaa = "001,002,003,004,005,006,007,008,009,011,012,013,014,015,017";
		System.out.println(aaa);
		System.out.println(zipList(aaa));
		
		String bbb = "001,003,005,006,008,009,012,013,014,015,017,018,020";
		System.out.println(bbb);
		System.out.println(zipList(bbb));
		
		String ccc = "001,003,005,006,008,010,011";
		System.out.println(ccc);
		System.out.println(zipList(ccc));
		
		String ddd = "001";
		System.out.println(ddd);
		System.out.println(zipList(ddd));
		
		String eee = "001,002,003,005,007";
		System.out.println(eee);
		System.out.println(zipList(eee));
		
		String fff = "001,003,004,006,009,010,012,014,015,016,018";
		System.out.println(fff);
		System.out.println(zipList(fff));
	}
	
	public static String zipList(String source) {
		StringBuffer target = new StringBuffer();
		List<String> list = Arrays.asList(source.split(","));
		if(1 == list.size()) {
			return list.get(0) + ";";
		}
		
		int startIndex = 0;
		int endIndex = 0;
		boolean isFirst = true;
		for(int i = 1; i < list.size(); i++) {
			double last = Double.valueOf(list.get(i - 1));
			double now = Double.valueOf(list.get(i));
			if(isFirst) {
				startIndex = i - 1;
				target.append(list.get(i - 1));
				isFirst = false;
			}
			
			if(now - last == 1 && !isFirst && i != list.size() - 1) {
				continue;
			}
			
			if(now - last > 1) {
				endIndex = i - 1;
			}
			
			if(startIndex == endIndex) {
				target.append(";");
				isFirst = true;
			} else {
				target.append("-");
				target.append(list.get(i - 1));
				target.append(";");
				isFirst = true;
			}
			
			if(i == list.size() - 1 && now - last > 1) {
				target.append(list.get(i));
				target.append(";");
			}
			
		}
		
		return target.toString();
	}

}
