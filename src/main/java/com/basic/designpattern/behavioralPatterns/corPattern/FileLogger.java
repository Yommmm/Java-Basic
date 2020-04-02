package com.basic.designpattern.behavioralPatterns.corPattern;

public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("FileLogger " + message);		
	}

}
