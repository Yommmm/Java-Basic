package com.basic.basic;

public class StringDemo {

    private static final String a = "1";

    public static void main(String[] args) {
        testStringMemory();
        Math.round(-1.5);
    }

    public static void testStringMemory() {
        String a = "programming";
        String b = new String("programming");
        String c = "program" + "ming";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());
        System.out.println(a == b.intern());
    }

    /**
     * 字符串逆转，递归
     * @param str
     * @return
     */
    public String re(String str) {
        if(null == str || str.length() <= 1) {
            return str;
        }
        return re(str.substring(1)) + str.charAt(0);
    }

}
