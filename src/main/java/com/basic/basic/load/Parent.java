package com.basic.basic.load;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class Parent {

    static {
        System.out.println("parent static code");
    }

    {
        new Output("parent code");
    }

    private static final Output output = new Output("parent static final");

    public Parent() {
        System.out.println("parent contruct");
    }

    private Output element = new Output("parent element");

}
