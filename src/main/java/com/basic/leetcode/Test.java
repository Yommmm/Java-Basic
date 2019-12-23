package com.basic.leetcode;

public class Test {

    public static void main(String[] args) throws Exception {
        int i = 0;
        while (i < 100) {
            double ceil = Math.ceil(Math.random() * 10000);

            if(ceil > 0 && ceil < 3000) {
                System.out.println("给瑶瑶");
            }
            Thread.sleep(100);

            if(ceil > 3000 && ceil < 6000) {
                System.out.println("给倩倩");
            }
            Thread.sleep(100);

            if(ceil > 6000) {
                System.out.println("保命要紧！给楠哥！");
            }
            Thread.sleep(100);
            i++;
        }

        System.out.println("给倩倩！");

    }

}
