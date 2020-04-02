package com.basic.designpattern.structuralPatterns.proxyPattern;

public class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		this.loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying: " + fileName);
	}
	
	public void loadFromDisk(String fileName) {
		System.out.println("Loading: " + fileName);
	}

}
