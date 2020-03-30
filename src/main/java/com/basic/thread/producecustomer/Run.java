package com.basic.thread.producecustomer;

public class Run {

    public static void main(String[] args) {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Customer customer = new Customer(lock);

        ThreadP threadP1 = new ThreadP(producer);
        threadP1.setName("P1");
        ThreadP threadP2 = new ThreadP(producer);
        threadP2.setName("P2");
        ThreadC threadC1 = new ThreadC(customer);
        threadC1.setName("C1");
        ThreadC threadC2 = new ThreadC(customer);
        threadC2.setName("C2");

        threadP1.start();
        threadP2.start();
        threadC1.start();
        threadC2.start();
    }

}
