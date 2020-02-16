package com.basic.basic;

public class Son extends Parent {
    static {
        System.out.println("Son static");
    }
    {
        System.out.println("Son");
    }
    public Son() {
        System.out.println("Son construct");
    }
    public static void main(String[] args) {
        new Son();
    }
}
abstract class Parent {
    static {
        System.out.println("Parent static");
    }
    {
        System.out.println("Parent");
    }
    public Parent() {
        System.out.println("Parent construct");
    }
}
