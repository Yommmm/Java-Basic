package com.basic.designpattern.behavioralPatterns.corPattern;

public class CorPatternDemo {

	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		
		System.out.println("=========================================================================================");
		System.out.println();

		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

		System.out.println("=========================================================================================");
		System.out.println();
		
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
	}
	
	private static AbstractLogger getChainOfLoggers() {
		
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.INFO);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.DEBUG);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		
		return errorLogger;
	}
}
