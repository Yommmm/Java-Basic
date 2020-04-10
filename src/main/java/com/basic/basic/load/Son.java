package com.basic.basic.load;

/**
 * TODO
 *
 * @author 85374
 * @date
 */
public class Son extends Parent {

    static {
        System.out.println("son static code");
    }

    {
        new Output("son code");
    }

    private static final Output output = new Output("son static final");

    public Son() {
        System.out.println("son contruct");
    }

    private Output element = new Output("son element");

}
