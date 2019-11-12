package com.basic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {

	public static void main(String[] args) throws ParseException {
		String oldVehicles = "湘A12345,湘A12346,湘A12347,湘A12348,湘A12349";
    	String newVehicles = "湘A12345,湘A12346,湘A12347,湘A12310,湘A12311";
    	/*if(!oldVehicles.equals(newVehicles)) {
    		// TODO 对比前后，生成/废除 门禁许可
    		List<String> oldVehicleList = Arrays.asList(oldVehicles.split(","));
    		List<String> newVehicleList = Arrays.asList(newVehicles.split(","));
    		
    		List<String> delList = new ArrayList<>(oldVehicleList);
    		List<String> addList = new ArrayList<>(newVehicleList);
    		List<String> tempList = new ArrayList<>(oldVehicleList);
    		
    		tempList.retainAll(addList);
    		
    		delList.removeAll(tempList);
    		addList.removeAll(tempList);
    		System.out.println(delList);
    		System.out.println(addList);
    	}*/
    	
		List<String> list1 = new ArrayList<>();
		list1.add("1111");
		list1.add("2222");
		list1.add("3333");
		list1.add("4444");

		List<String> list2 = new ArrayList<>();
		list2.add("3333");
		list2.add("4444");
		list2.add("5555");

		// 并集
		List<String> temp = new ArrayList<>(list1);
		temp.retainAll(list2);
		list1.removeAll(temp);
		list1.addAll(list2);
		System.out.println(list1);
		
	}
	
}
