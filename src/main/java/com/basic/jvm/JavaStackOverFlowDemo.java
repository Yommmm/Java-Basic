package com.basic.jvm;

/**
 * 未设置递归终止条件的方法区的栈溢出，栈帧太多了
 * -Xss128k -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./dump
 */
public class JavaStackOverFlowDemo {

    private int stacklength = 1;

    public void stack() {
        stacklength++;
        stack();
    }

    public static void main(String[] args) {
        JavaStackOverFlowDemo demo = new JavaStackOverFlowDemo();
        try {
            demo.stack();
        } catch (Exception e) {
            System.out.println(demo.stacklength);
            throw e;
        }
    }
}
