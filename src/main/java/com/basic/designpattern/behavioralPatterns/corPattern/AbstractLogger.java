package com.basic.designpattern.behavioralPatterns.corPattern;

public abstract class AbstractLogger {

	public static final int DEBUG = 1;

	public static final int INFO = 2;

	public static final int ERROR = 3;

	protected int level;

	private AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	/**
	 * 递归向下一个责任传递消息
	 * @param level
	 * @param message
	 */
	public void logMessage(int level, String message) {
		if (this.level <= level) {
			this.write(message);
		}
		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
	}

	abstract protected void write(String message);
}
