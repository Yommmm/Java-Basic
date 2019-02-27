package com.basic.thread.threadlocal;

public class InheritableThreadLocalExt extends InheritableThreadLocal<String> {

	@Override
	protected String childValue(String parentValue) {
		return super.childValue("子线程" + parentValue);
	}
	
}
